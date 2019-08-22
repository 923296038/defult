package com.controller;

import com.service.WorkService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.Work;
import java.util.List;

@Controller
public class WorkController {
    @Autowired
    WorkService workService;
    private static final Logger log= LogManager.getLogger(WorkController.class);

    //作品列表
    @RequestMapping(value = "Works/AllWorks",method = RequestMethod.GET)
    @ResponseBody
    public String allW(){
        List<Work> workList = workService.selectAll();
        log.error(workList);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + workList;
    }
    //根据作品名查找
    @RequestMapping(value = "Works/WorksByName",method = RequestMethod.GET)
    @ResponseBody
    public String worksBN(@RequestBody String work_name){
        List<Work> workList = workService.selectByWorkName(work_name);
        log.error(work_name);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + workList;
    }
    //新增作品
    @RequestMapping(value = "Works/MoreWorks",method = RequestMethod.POST)
    @ResponseBody
    public String moreW(Work work){
        work.setCreate_at(System.currentTimeMillis());
        work.setUpdate_at(System.currentTimeMillis());

        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + workService.insert(work);
    }
    //编辑
    @RequestMapping(value = "Works/WorksInfo",method = RequestMethod.PUT)
    @ResponseBody
    public String workI(Work work){
        work.setUpdate_at(System.currentTimeMillis());
        List<Work> workList = workService.selectByWorkName(work.getWork_name());
        workService.updateByPrimaryKey(work);
        List<Work> workList1 = workService.selectByWorkName(work.getWork_name());
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //上架
    @RequestMapping(value = "Works/UpWorks",method = RequestMethod.PUT)
    @ResponseBody
    public String upW(Long id){
        workService.upWork(id);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //下架
    @RequestMapping(value = "Works/DownWorks",method = RequestMethod.PUT)
    @ResponseBody
    public String downW(Long id){
        workService.downWork(id);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //删除
    @RequestMapping(value = "Works/LesserWorks",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserW(@RequestBody Long id){
        List<Work> workList = workService.selectAll();
        workService.deleteByPrimaryKey(id);
        List<Work> workList1 = workService.selectAll();
        int flag = (workList.size()-workList1.size());
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
