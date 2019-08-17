package com.controller;

import com.service.WorkService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    //作品列表√
    @RequestMapping(value = "Works/AllWorks",method = RequestMethod.GET)
    @ResponseBody
    public List<Work> allW(){
        List<Work> workList = workService.selectAll();
        log.error(workList);
        return workList;
    }
    //根据作品名查找√
    @RequestMapping(value = "Works/WorksByName",method = RequestMethod.GET)
    @ResponseBody
    public String worksBN(String work_name){
        List<Work> workList = workService.selectByWorkName(work_name);
        log.error(work_name);
        return "根据名字查询结果:"+workList;
    }
    //新增作品√
    @RequestMapping(value = "Works/MoreWorks",method = RequestMethod.POST)
    @ResponseBody
    public String moreW(Work work){
        work.setCreate_at(System.currentTimeMillis());
        work.setUpdate_at(System.currentTimeMillis());
        workService.insert(work);
        return "添加一个新作品:"+work;
    }
    //编辑√
    @RequestMapping(value = "Works/WorkInfo",method = RequestMethod.POST)
    @ResponseBody
    public String workI(Work work){
        work.setUpdate_at(System.currentTimeMillis());
        List<Work> workList = workService.selectByWorkName(work.getWork_name());
        workService.updateByPrimaryKey(work);
        List<Work> workList1 = workService.selectByWorkName(work.getWork_name());
        return "修改前:"+workList+";修改后"+workList1;
    }
    //上架√
    @RequestMapping(value = "Works/UpWork",method = RequestMethod.POST)
    @ResponseBody
    public String upW(Long id){
        workService.upWork(id);
        return "success";
    }
    //下架√
    @RequestMapping(value = "Works/DownWork",method = RequestMethod.POST)
    @ResponseBody
    public String downW(Long id){
        workService.downWork(id);
        return "success";
    }
    //删除√
    @RequestMapping(value = "Works/LesserWorks",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserW(Long id){
        List<Work> workList = workService.selectAll();
        workService.deleteByPrimaryKey(id);
        List<Work> workList1 = workService.selectAll();
        return "delete   :"+(workList.size()-workList1.size())+"   record";
    }
}
