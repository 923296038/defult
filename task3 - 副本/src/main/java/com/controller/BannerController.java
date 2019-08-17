package com.controller;

import com.pojo.Banner;
import com.service.BannerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public List<Banner> allB(){
        List<Banner> bannerList = bannerService.findAllBanner();
        log.error(bannerList);
        return bannerList;
    }
    //根据创建人查询
    @RequestMapping(value = "Banners/BannersByCreateBy",method = RequestMethod.GET)
    @ResponseBody
    public List<Banner> bannersByC(String create_by){
        List<Banner> bannerList = bannerService.findByName(create_by);
        log.error(bannerList);
        return bannerList;
    }
    //根据状态查询
    @RequestMapping(value = "Banners/BannersByStatus",method = RequestMethod.GET)
    @ResponseBody
    public List<Banner> bannersBS(String status){
        List<Banner> bannerList = bannerService.findByStatus(status);
        log.error(bannerList);
        return bannerList;
    }
    //新增
    @RequestMapping(value = "Banners/MoreBanners",method = RequestMethod.POST)
    @ResponseBody
    public String moreB(Banner banner){
        banner.setCreate_at(System.currentTimeMillis());
        banner.setUpdate_at(System.currentTimeMillis());
        bannerService.insertBanner(banner);
        log.error(banner);
        return ""+banner;
    }
    //编辑
    @RequestMapping(value = "Banners/BannerInfo",method = RequestMethod.POST)
    @ResponseBody
    public String bannerI(Banner banner){
        banner.setUpdate_at(System.currentTimeMillis());
        bannerService.updateBanner(banner);
        Banner banner1 = bannerService.findById(banner.getId());
        log.error(banner1);
        return "new record   "+banner1;
    }
    //上架
    @RequestMapping(value = "Banners/UpBanner",method = RequestMethod.POST)
    @ResponseBody
    public String upB(Long id){
        bannerService.upBanner(id);
        Banner banner = bannerService.findById(id);
        log.error(banner);
        return "result : "+banner;
    }
    //下架
    @RequestMapping(value = "Banners/DownBanner",method = RequestMethod.POST)
    @ResponseBody
    public String downB(Long id){
        bannerService.downBanner(id);
        Banner banner = bannerService.findById(id);
        log.error(banner);
        return "result : "+banner;
    }
    //删除
    @RequestMapping(value = "Banners/LesserBanners",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserB(Long id){
        List<Banner> bannerList = bannerService.findAllBanner();
        bannerService.deleteBanner(id);
        List<Banner> bannerList1 = bannerService.findAllBanner();
        log.error("delete "+(bannerList.size()-bannerList1.size())+" record");
        return "delete "+(bannerList.size()-bannerList1.size())+" record";
    }
}
