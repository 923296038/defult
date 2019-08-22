package com.controller;

import com.pojo.Type;
import com.pojo.Volume;
import com.service.TypeService;
import com.service.VolumeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String AV(){
        List<Volume> volumeList = volumeService.findAll();
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + volumeList;
    }
    //根据作品集名称查询
    @RequestMapping(value = "Volumes/VolumesByName",method = RequestMethod.GET)
    @ResponseBody
    public String VBN(@RequestBody String volume_name){
        List<Volume> volumeList = volumeService.findByName(volume_name);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + volumeList;
    }
    //根据状态查询
    @RequestMapping(value = "Volumes/VolumesByStatus",method = RequestMethod.GET)
    @ResponseBody
    public String VBS(@RequestBody String status){
        List<Volume> volumeList = volumeService.findByStatus(status);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + volumeList;
    }
    //二级标题,注意查询方法时搜索对象是作品集分类列表
    @RequestMapping(value = "Volumes/SecondTitles",method = RequestMethod.GET)
    @ResponseBody
    public String second(@RequestBody String volume_name){
        List<Type> typeList = typeService.findByVolumeName(volume_name);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + typeList;
    }
    //新增作品集
    @RequestMapping(value = "Volumes/MoreVolumes",method = RequestMethod.POST)
    @ResponseBody
    public String More(Volume volume) {
        List<Volume> volumeList = volumeService.findAll();
        int number = volumeList.size();
        volume.setCreate_at(System.currentTimeMillis());
        volume.setUpdate_at(System.currentTimeMillis());
        if (number < 7) {

            log.error(volume);
            return "status: " + "200\r" +
                    "message: " + "success\r" +
                    "data: " + volumeService.insertVolume(volume);
        } else {
            log.error("当前作品集数量 " + volumeList.size() + ",无法再上架");
            return "status: " + "500\r" +
                    "message: " + "cannot create more than 7 volumes\r" +
                    "data: " + false;
        }
    }
    //编辑
    @RequestMapping(value = "Volumes/VolumesInfo",method = RequestMethod.PUT)
    @ResponseBody
    public String VI(Volume volume){
        volume.setUpdate_at(System.currentTimeMillis());
        volumeService.updateVolume(volume);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //上架
    @RequestMapping(value = "Volumes/UpVolumes",method = RequestMethod.PUT)
    @ResponseBody
    public String up(Long id){
        boolean flag = volumeService.upVolume(id);
        if(flag){return
                        "status: " + "200\r" +
                        "message: " + "success\r" +
                        "data: " + true;}
        else return
                "status: " + "500\r" +
                "message: " + "error!\r" +
                "data: " + false;
    }
    //下架,增加一个业务逻辑:无下级时才可下架
    @RequestMapping(value = "Volumes/DownVolumes",method = RequestMethod.PUT)
    @ResponseBody
    public String down(Long id){
        Volume volume = volumeService.findById(id);
        log.error(volume);
        List<Type> typeList = typeService.findByVolumeName(volume.getVolume_name());
        log.error(typeList);
        if(typeList.size()==0){
        volumeService.downVolume(id);
        Type type1 = typeService.findById(id);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;}
        else return "status: " + "500\r" +
                "message: " + "error,because it has second works\r" +
                "data: " + false;
    }
    //删除,增加一个业务逻辑:下架状态&无下级时才可删除
    @RequestMapping(value = "Volumes/LesserVolumes",method = RequestMethod.DELETE)
    @ResponseBody
    public String LV(@RequestBody Long id){
        Volume volume = volumeService.findById(id);
        log.error(volume);
        List<Type> typeList = typeService.findByVolumeName(volume.getVolume_name());
        if(volume.getStatus()==null||(!volume.getStatus().equals("上架") &&typeList.size()==0))
        {volumeService.deleteVolume(id);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;}
        else return "status: " + "500\r" +
                "message: " + "error!because it has second works or status is 'up'\r" +
                "data: " + false;

    }

}
