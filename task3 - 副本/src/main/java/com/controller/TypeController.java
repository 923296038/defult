package com.controller;

import com.pojo.Type;
import com.pojo.Work;
import com.service.TypeService;
import com.service.WorkService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

@Controller
public class TypeController {
    @Autowired
    TypeService typeService;
    @Autowired
    WorkService workService;
    private static final Logger log= LogManager.getLogger(TypeController.class);

    //作品集分类列表
    @RequestMapping(value = "Types/AllTypes",method = RequestMethod.GET)
    @ResponseBody
    public String AllT(){
        List<Type> typeList = typeService.findAll();
        log.error(typeList.size());
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + typeList;
    }
    //下级作品列表
    @RequestMapping(value = "Types/Works",method = RequestMethod.GET)
    @ResponseBody
    public String works(@RequestBody String volume_name){
        List<Work> workList = workService.selectByVolumeName(volume_name);
        log.error(workList);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + workList;
    }
    //find by name作品集分类名称
    @RequestMapping(value = "Types/TypesByName",method = RequestMethod.GET)
    @ResponseBody
    public String TBN(@RequestBody String type_name){
        List<Type> typeList = typeService.findByTypeName(type_name);
        log.error(typeList);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + typeList;
    }
    //新增 作品集分类名称 ,所属作品集不可变
    @RequestMapping(value = "Types/MoreTypes",method = RequestMethod.POST)
    @ResponseBody
    public String moreT(Type type){
        type.setCreate_at(System.currentTimeMillis());
        type.setUpdate_at(System.currentTimeMillis());

        log.error(type);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + typeService.insert(type);
    }
    //编辑 同上
    @RequestMapping(value = "Types/TypesInfo",method = RequestMethod.PUT)
    @ResponseBody
    public String typeI(Type type1){
        Type type = typeService.findById(type1.getId());
        type1.setUpdate_at(System.currentTimeMillis());
        typeService.updateByPrimaryKey(type1);
        log.error("before:"+type);
        log.error("after"+type1);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //上架
    @RequestMapping(value = "Types/UpTypes",method = RequestMethod.PUT)
    @ResponseBody
    public String up(Long id){
        typeService.upType(id);
        Type type = typeService.findById(id);
        log.error(type);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //下架
    @RequestMapping(value = "Types/DownTypes",method = RequestMethod.PUT)
    @ResponseBody
    public String down(Long id){
        typeService.downType(id);
        Type type = typeService.findById(id);
        log.error(type);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //删除
    @RequestMapping(value = "Types/LesserTypes",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserT(@RequestBody Long id){
        List<Type> typeList = typeService.findAll();
        typeService.deleteByPrimaryKey(id);
        List<Type> typeList1 = typeService.findAll();
        int flag=typeList.size()-typeList1.size();
        log.error("删除了 "+flag+" 条数据");
        if (flag>0) {
            return "status: " + "200\r" +
                    "message: " + "success\r" +
                    "data: " + true;
        }
        else return "status: " + "500\r" +
                "message: " + "error\r" +
                "data: " + false;
    }
}
