package com.controller;

import com.pojo.Type;
import com.pojo.Volume;
import com.service.TypeService;
import com.service.VolumeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class VolumeController {
    @Autowired
    VolumeService volumeService;
    @Autowired
    TypeService typeService;
    private static final Logger log= LogManager.getLogger(VolumeController.class);
    //作品集列表
    @RequestMapping(value = "Volumes/AllVolumes",method = RequestMethod.GET)
    @ResponseBody
    public List<Volume> AV(){
        List<Volume> volumeList = volumeService.findAll();
        return volumeList;
    }
    //根据作品集名称查询
    @RequestMapping(value = "Volumes/VolumesByName",method = RequestMethod.GET)
    @ResponseBody
    public List<Volume> VBN(String volume_name){
        List<Volume> volumeList = volumeService.findByName(volume_name);
        return volumeList;
    }
    //根据状态查询
    @RequestMapping(value = "Volumes/VolumesByStatus",method = RequestMethod.GET)
    @ResponseBody
    public List<Volume> VBS(String status){
        List<Volume> volumeList = volumeService.findByStatus(status);
        return volumeList;
    }
    //新增作品集
    @RequestMapping(value = "Volumes/MoreVolumes",method = RequestMethod.POST)
    @ResponseBody
    public String More(Volume volume){
//        Volume volume =new Volume();
        volume.setCreate_at(System.currentTimeMillis());
        volume.setUpdate_at(System.currentTimeMillis());
        volumeService.insertVolume(volume);
        log.error(volume);
        return "success";

    }
    //编辑
    @RequestMapping(value = "Volumes/VolumeInfo",method = RequestMethod.POST)
    @ResponseBody
    public String VI(Volume volume){
        volume.setUpdate_at(System.currentTimeMillis());
        volumeService.updateVolume(volume);
        return "success";
    }
    //上架
    @RequestMapping(value = "Volumes/UpVolume",method = RequestMethod.POST)
    @ResponseBody
    public String up(Long id){
        boolean flag = volumeService.upVolume(id);
        if(flag){return "success";}
        else return "error";
    }
    //下架,增加一个业务逻辑:无下级时才可下架
    @RequestMapping(value = "Volumes/DownVolume",method = RequestMethod.POST)
    @ResponseBody
    public String down(Long id){
        Volume volume = volumeService.findById(id);
        log.error(volume);
        List<Type> typeList = typeService.findByVolumeName(volume.getVolume_name());
        log.error(typeList);
        if(typeList.size()==0){
        volumeService.downVolume(id);
        Type type1 = typeService.findById(id);
        return "success"+type1;}
        else return "error";
    }
    //删除,增加一个业务逻辑:下架状态&无下级时才可删除
    @RequestMapping(value = "Volumes/LesserVolumes",method = RequestMethod.DELETE)
    @ResponseBody
    public String LV(Long id){
        Volume volume = volumeService.findById(id);
        log.error(volume);
        List<Type> typeList = typeService.findByVolumeName(volume.getVolume_name());
        if(volume.getStatus().equals("下架") &&typeList.size()==0)
        {volumeService.deleteVolume(id);
        return "success";}
        else return "error";
    }
    //二级标题,注意查询方法时搜索对象是作品集分类列表
    @RequestMapping(value = "Volumes/SecondTitle",method = RequestMethod.GET)
    @ResponseBody
    public List<Type> second(String volume_name){
        List<Type> typeList = typeService.findByVolumeName(volume_name);
        return typeList;
    }
}
