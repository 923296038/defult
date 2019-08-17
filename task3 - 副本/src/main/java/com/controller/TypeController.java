package com.controller;

import com.pojo.Type;
import com.service.TypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TypeController {
    @Autowired
    TypeService typeService;
    private static final Logger log= LogManager.getLogger(TypeController.class);

    //作品集分类列表
    @RequestMapping(value = "Types/AllTypes",method = RequestMethod.GET)
    @ResponseBody
    public List<Type> AllT(){
        List<Type> typeList = typeService.findAll();
        log.error(typeList.size());
        return typeList;
    }
    //find by name作品集分类名称
    @RequestMapping(value = "Types/TypesByName",method = RequestMethod.GET)
    @ResponseBody
    public List<Type> TBN(String type_name){
        List<Type> typeList = typeService.findByTypeName(type_name);
        log.error(typeList);
        return typeList;
    }
    //新增 作品集分类名称 ,所属作品集不可变
    @RequestMapping(value = "Types/MoreTypes",method = RequestMethod.POST)
    @ResponseBody
    public String moreT(Type type){
        type.setCreate_at(System.currentTimeMillis());
        type.setUpdate_at(System.currentTimeMillis());
        typeService.insert(type);
        log.error(type);
        return "create a new type:"+type;
    }
    //编辑 同上
    @RequestMapping(value = "Types/TypeInfo",method = RequestMethod.POST)
    @ResponseBody
    public String typeI(Type type1){
        Type type = typeService.findById(type1.getId());
        type1.setUpdate_at(System.currentTimeMillis());
        typeService.updateByPrimaryKey(type1);
        log.error("before:"+type);
        log.error("after"+type1);
        return "before:"+type+"after"+type1;
    }
    //上架
    @RequestMapping(value = "Types/UpType",method = RequestMethod.POST)
    @ResponseBody
    public Type up(Long id){
        typeService.upType(id);
        Type type = typeService.findById(id);
        log.error(type);
        return type;
    }
    //下架
    @RequestMapping(value = "Types/DownType",method = RequestMethod.POST)
    @ResponseBody
    public Type down(Long id){
        typeService.downType(id);
        Type type = typeService.findById(id);
        log.error(type);
        return type;
    }
    //删除
    @RequestMapping(value = "Types/LesserTypes",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserT(Long id){
        List<Type> typeList = typeService.findAll();
        typeService.deleteByPrimaryKey(id);
        List<Type> typeList1 = typeService.findAll();
        long flag=typeList.size()-typeList1.size();
        log.error("数据数量改动为:"+"-"+flag);
        return "reduced "+flag+"data";
    }
}
