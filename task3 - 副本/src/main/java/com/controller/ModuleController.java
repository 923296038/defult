package com.controller;

import com.service.ModuleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.Module;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import java.util.List;

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
        return ""+moduleList;
    }
    //根据模块名查询
    @RequestMapping(value = "Modules/ModuleByName",method = RequestMethod.GET)
    @ResponseBody
    public String moduleBN(String module_name){
        List<Module> moduleList = moduleService.findByModuleName(module_name);
        log.error(moduleList);
        return ""+moduleList;
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
            return "error ! "+allErrors;
        }
        module.setCreate_at(System.currentTimeMillis());
        moduleService.insertModule(module);
        log.error("新增的数据"+module);
        return "new module : "+module;
    }
    //编辑 同上
    @RequestMapping(value = "Modules/ModuleInfo",method = RequestMethod.PUT)
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
            return "error ! "+allErrors;
        }
        Module module1 = moduleService.findById(module.getId());
        moduleService.updateModule(module);
        log.error("编辑的数据"+module);
        return "previous module"+module1+"new module : "+module;
    }
    //删除
    @RequestMapping(value = "Modules/LesserModules",method = RequestMethod.DELETE)
    @ResponseBody
    public String moduleL(Long id){
        List<Module> moduleList = moduleService.findAll();
        moduleService.deleteModule(id);
        List<Module> moduleList1 = moduleService.findAll();
        log.error("删除了 "+(moduleList.size()-moduleList1.size())+" 条数据");
        return "delete "+(moduleList.size()-moduleList1.size())+" record" ;
    }
}
