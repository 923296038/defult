package com.controller;

import com.service.RoleService;
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
import com.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;
    private static final Logger log = LogManager.getLogger(RoleController.class);

    //角色列表
    @RequestMapping(value = "Roles/AllRoles",method = RequestMethod.GET)
    @ResponseBody
    public String allR(){
        List<Role> roleList = roleService.findAll();
        log.error(roleList);
        return ""+roleList;
    }
    //根据角色查询
    @RequestMapping(value = "Roles/RoleByRole",method = RequestMethod.GET)
    @ResponseBody
    public String roleBR(String role){
        List<Role> roleList = roleService.findByRole(role);
        log.error(roleList);
        return ""+roleList;
    }
    //新增角色 角色名非空 权限非空
    @RequestMapping(value = "Roles/MoreRoles",method = RequestMethod.POST)
    @ResponseBody
    public String moreR(HttpServletRequest request,
                        @Validated Role role,
                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            log.error("执行了if语句块");
            return "error ! "+allErrors;
        }
        role.setCreate_at(System.currentTimeMillis());
        roleService.insert(role);
        log.error(role);
        return ""+role;
    }
    //编辑 同上
    @RequestMapping(value = "Roles/RoleInfo",method = RequestMethod.PUT)
    @ResponseBody
    public String roleI(HttpServletRequest request,
                        @Validated Role role,
                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            log.error("执行了if语句块");
            return "error ! "+allErrors;
        }
        roleService.updateByPrimaryKey(role);
        log.error(role);
        return "updated : "+role;
    }
    //删除
    @RequestMapping(value = "Roles/LesserRoles",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserR(Long id){
        List<Role> roleList = roleService.findAll();
        roleService.deleteByPrimaryKey(id);
        List<Role> roleList1 = roleService.findAll();
        log.error("删除了 "+(roleList.size()-roleList1.size())+" 条数据");
        return "deleted "+(roleList.size()-roleList1.size())+" record";
    }
}
