package com.controller;

import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Message;
import com.pojo.Studio;
import com.service.MessageService;
import com.service.StudioService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudioController {
    @Autowired
    StudioService studioService;
    private static final Logger log= LogManager.getLogger(StudioController.class);
    //工作室列表
    @RequestMapping(value = "Studios/AllStudios",method = RequestMethod.GET)
    public String AllS(Model model,@RequestParam(defaultValue = "1",required = true,
            value = "pageNo") Integer pageNo){
        Integer pageSize=5;
        PageHelper.startPage(pageNo,pageSize);
        List<Studio> studioList = studioService.findAll();
        PageInfo<Studio> pageInfo = new PageInfo<>(studioList);
        model.addAttribute("pageInfo",pageInfo);
        log.error("查询所有"+pageInfo);
        return "AllStudios";
    }
    //根据名称查询
    @RequestMapping(value = "Studios/StudiosByName",method = RequestMethod.GET)
    public String StudioBN(Model model,  HttpServletRequest request, String studio_name,
                           @Validated Studio studio, BindingResult bindingResult){
        if(studio_name.length()==0&&bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors",allErrors);
            log.error(bindingResult);
            return "Error";
        }
        List<Studio> studioList = studioService.findByStudioName(studio_name);
        model.addAttribute("studioList",studioList);
        log.error("据名查询"+studioList);
        return "StudioFBN";
    }
    //根据状态查询
    @RequestMapping(value = "Studios/StudiosByStatus",method = RequestMethod.GET)
    public String StudioBS(Model model,@RequestParam(defaultValue = "1",required = true,
            value = "pageNo") Integer pageNo,HttpServletRequest request,String status,
                           @Validated Studio studio,BindingResult bindingResult){
        if(status.length()==0&&bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors",allErrors);
            log.error(bindingResult);
            return "Error";
        }
        Integer pageSize=5;
        PageHelper.startPage(pageNo,pageSize);
        List<Studio> studioList=studioService.findByStatus(status);
        PageInfo<Studio> pageInfo= new PageInfo<>(studioList);
        model.addAttribute("pagaInfo",pageInfo);
        log.error("据状态查询"+pageInfo);
        return "StudioFBS";
    }
    //去新增
    @RequestMapping(value = "Studios/toMoreStudios",method = RequestMethod.GET)
    public String toMoreS(){

        return "MoreStudios";
    }
    //新增,简介类型,图片,正文
    @RequestMapping(value = "Studios/MoreStudios",method = RequestMethod.POST)
    @ResponseBody
    public String MoreS(Model model,HttpServletRequest request,
                        @Validated Studio studio,BindingResult bindingResult){
        if(studio.getStudio_name().length()==0||bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors",allErrors);
            log.error("执行了if语句块");
            return "Error";
        }
        studio.setCreate_at(System.currentTimeMillis());
        studio.setUpdate_at(System.currentTimeMillis());
        studioService.insert(studio);
        model.addAttribute("studio",studio);
        return "Success";
    }
    //去编辑
    @RequestMapping(value = "Studios/toStudioInfo/{id}",method = RequestMethod.GET)
    public String toStudioI(Model model, @PathVariable Long id){
        Studio studio=studioService.selectByPrimaryKey(id);
        model.addAttribute("studio",studio);
        return "StudioInfo";
    }
    //编辑
    @RequestMapping(value = "Studios/StudioInfo",method = RequestMethod.POST)
    @ResponseBody
    public String StudioI(Model model,HttpServletRequest request,
                          @Validated Studio studio,BindingResult bindingResult){
        if(studio.getStudio_name().length()==0||bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            model.addAttribute("allErrors",allErrors);
            return "Error";
        }
        studio.setUpdate_at(System.currentTimeMillis());
        boolean flag = studioService.updateByPrimaryKey(studio);
        if(flag=true)
        {return "Success";}
        return "Error";
    }
    /*//上架
    @RequestMapping(value = "Studios/UpStudio/{id}",method = RequestMethod.POST)
    public String UpS(Model model,@PathVariable Long id){
        studioService.upStudio(id);
        log.error("上架了工作室:"+id);
        return "redirect:/Studios/AllStudios";
    }
    //下架
    @RequestMapping(value = "Studiso/DownStudio/{id}",method = RequestMethod.POST)
    public String DownS(Model model,@PathVariable Long id){
        studioService.downStudio(id);
        log.error("下架了工作室"+id);
        return "redirect:/Studios/AllStudios";
    }*/
    //去上架
    @RequestMapping(value = "Studios/toUp/{id}",method = RequestMethod.GET)
    public String toU(Model model,@PathVariable Long id){
        Studio studio = studioService.selectByPrimaryKey(id);
        model.addAttribute("studio",studio);
        return "UpStudio";
    }
    //去下架
    @RequestMapping(value = "Studios/toDown/{id}",method = RequestMethod.GET)
    public String toD(Model model,@PathVariable Long id){
        Studio studio = studioService.selectByPrimaryKey(id);
        model.addAttribute("studio",studio);
        return "DownStudio";
    }
    //上架
    @RequestMapping(value = "Studios/UpStudio/{id}",method = RequestMethod.POST)
    public String US(@PathVariable Long id){
        studioService.upStudio(id);
        log.error("上架了工作室,id为"+id);
        return "redirect:/Studios/AllStudios";
    }
    //下架
    @RequestMapping(value = "Studios/DownStudio/{id}",method = RequestMethod.POST)
    public String DS(@PathVariable Long id){
        studioService.downStudio(id);
        log.error("下架了工作室,id为"+id);
        return "redirect:/Studios/AllStudios";
    }
    //测试json
    @RequestMapping(value = "Studios/Json")
    public String selectAll(Model model) {
        List<Studio> studioList = studioService.findAll();
        model.addAttribute("code", "200");
        model.addAttribute("message", "传递成功");
        model.addAttribute("studioList", studioList);
        return "Json";
    }


    //用于测试
    @RequestMapping(value = "/Json")
    @ResponseBody
    public List<Studio> J(){
        List<Studio> studioList = studioService.findAll();
        return studioList;
    }

    @RequestMapping(value = "/Json2")
    @ResponseBody
    public String S(){
        String s = "update success";
        return s;
    }
}
