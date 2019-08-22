package com.controller;

import com.pojo.Banner;
import com.service.BannerService;
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
public class BannerController {
    @Autowired
    BannerService bannerService;
    private static final Logger log= LogManager.getLogger(BannerController.class);

    //banner列表
    @RequestMapping(value = "Banners/AllBanners",method = RequestMethod.GET)
    @ResponseBody
    public String allB(){
        List<Banner> bannerList = bannerService.findAllBanner();
        log.error(bannerList);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + bannerList;
    }
    //根据创建人查询
    @RequestMapping(value = "Banners/BannersByCreateBy",method = RequestMethod.GET)
    @ResponseBody
    public String bannersByC(@RequestBody String create_by){
        List<Banner> bannerList = bannerService.findByName(create_by);
        log.error(bannerList);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + bannerList;
    }
    //根据状态查询
    @RequestMapping(value = "Banners/BannersByStatus",method = RequestMethod.GET)
    @ResponseBody
    public String bannersBS(@RequestBody String status){
        List<Banner> bannerList = bannerService.findByStatus(status);
        log.error(bannerList);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + bannerList;
    }
    //新增
    @RequestMapping(value = "Banners/MoreBanners",method = RequestMethod.POST)
    @ResponseBody
    public String moreB(Banner banner){
        banner.setCreate_at(System.currentTimeMillis());
        banner.setUpdate_at(System.currentTimeMillis());

        log.error(banner);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + bannerService.insertBanner(banner);
    }
    //编辑
    @RequestMapping(value = "Banners/BannersInfo",method = RequestMethod.PUT)
    @ResponseBody
    public String bannerI(Banner banner){
        banner.setUpdate_at(System.currentTimeMillis());
        bannerService.updateBanner(banner);
        Banner banner1 = bannerService.findById(banner.getId());
        log.error(banner1);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //上架
    @RequestMapping(value = "Banners/UpBanners",method = RequestMethod.PUT)
    @ResponseBody
    public String upB(Long id){
        bannerService.upBanner(id);
        Banner banner = bannerService.findById(id);
        log.error(banner);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //下架
    @RequestMapping(value = "Banners/DownBanners",method = RequestMethod.PUT)
    @ResponseBody
    public String downB(Long id){
        bannerService.downBanner(id);
        Banner banner = bannerService.findById(id);
        log.error(banner);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //删除
    @RequestMapping(value = "Banners/LesserBanners",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserB(@RequestBody Long id){
        List<Banner> bannerList = bannerService.findAllBanner();
        bannerService.deleteBanner(id);
        List<Banner> bannerList1 = bannerService.findAllBanner();
        int flag = (bannerList.size()-bannerList1.size());
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
