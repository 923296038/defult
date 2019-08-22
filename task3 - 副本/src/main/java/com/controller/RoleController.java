package com.controller;

import com.service.RoleService;
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
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + roleList;
    }
    //根据角色查询
    @RequestMapping(value = "Roles/RoleByRole",method = RequestMethod.GET)
    @ResponseBody
    public String roleBR(@RequestBody String role){
        List<Role> roleList = roleService.findByRole(role);
        log.error(roleList);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + roleList;
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
            return "status: " + "500\r" +
                    "message: " + allErrors+"\r" +
                    "data: " + false;
        }
        role.setCreate_at(System.currentTimeMillis());

        log.error(role);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + roleService.insert(role);
    }
    //编辑 同上
    @RequestMapping(value = "Roles/RolesInfo",method = RequestMethod.PUT)
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
            return "status: " + "500\r" +
                    "message: " + allErrors+"\r" +
                    "data: " + false;
        }
        roleService.updateByPrimaryKey(role);
        log.error(role);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
    //删除
    @RequestMapping(value = "Roles/LesserRoles",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserR(@RequestBody Long id){
        List<Role> roleList = roleService.findAll();
        roleService.deleteByPrimaryKey(id);
        List<Role> roleList1 = roleService.findAll();
        int flag = (roleList.size()-roleList1.size());
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
