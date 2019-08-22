package com.controller;

import com.service.ModuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.Module;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import java.util.List;

//测试到这

@Controller
public class ModuleController {
    @Autowired
    ModuleService moduleService;
    private static final Logger log= LogManager.getLogger(MessageController.class);

    //模块列表
    @RequestMapping(value = "Modules/AllModules",method = RequestMethod.GET)
    @ResponseBody
    public String allM(){
        List<Module> moduleList = moduleService.findAll();
        log.error(moduleList);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + moduleList;
    }
    //根据模块名查询
    @RequestMapping(value = "Modules/ModulesByName",method = RequestMethod.GET)
    @ResponseBody
    public String moduleBN(@RequestBody String module_name){
        List<Module> moduleList = moduleService.findByModuleName(module_name);
        log.error(moduleList);
        log.error(module_name);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + moduleList;
    }
    //新增模块 模块名非空 唯一  父节点ID非空  url
    @RequestMapping(value = "Modules/MoreModules",method = RequestMethod.POST)
    @ResponseBody
    public String moreM(HttpServletRequest request,
                        @Validated Module module,
                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            log.error("执行了if语句块");
            return "status: " + "500\r" +
                    "message: " + allErrors+"\r" +
                    "data: " + "no result";
        }
        module.setCreate_at(System.currentTimeMillis());

        log.error("新增的数据"+module);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + moduleService.insertModule(module);
    }
    //编辑 同上
    @RequestMapping(value = "Modules/ModulesInfo",method = RequestMethod.PUT)
    @ResponseBody
    public String moduleI(HttpServletRequest request,
                        @Validated Module module,
                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            log.error("执行了if语句块");
            return "status: " + "500\r" +
                    "message: " + allErrors+"\r" +
                    "data: " + false;
        }
        Module module1 = moduleService.findById(module.getId());
        moduleService.updateModule(module);
        log.error("编辑的数据"+module);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //删除
    @RequestMapping(value = "Modules/LesserModules",method = RequestMethod.DELETE)
    @ResponseBody
    public String moduleL(@RequestBody Long id){
        List<Module> moduleList = moduleService.findAll();
        moduleService.deleteModule(id);
        List<Module> moduleList1 = moduleService.findAll();
        int flag = (moduleList.size()-moduleList1.size());
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
