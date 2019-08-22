package com.controller;

import com.pojo.Password;
import com.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
* 未通过
* */
@Controller
public class PasswordController {
    @Autowired
    PasswordService passwordService;
    //修改密码
    @RequestMapping(value = "Password/NewPassword",method = RequestMethod.PUT)
    @ResponseBody
    public String newP(HttpServletRequest request,
                       @Validated Password password,
                       BindingResult bindingResult){
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(bindingResult.hasErrors()){
            for (ObjectError objectError:allErrors){
            }
            return "status: " + "500\r" +
                    "message: " + allErrors+"\r" +
                    "data: " + false;
        }
        boolean flag = passwordService.updatePassword(password);
        if(flag){return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;}
        else return "status: " + "500\r" +
                "message: " + "error\r" +
                "data: " + false;
    }
}
