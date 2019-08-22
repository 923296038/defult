package com.controller;

import com.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.pojo.Account;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
* 按账号名搜索是模糊搜索
* */

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;
    private static final Logger log= LogManager.getLogger(AccountController.class);

    //获取索引用户列表
    @RequestMapping(value = "Accounts/AllAccounts",method = RequestMethod.GET)
    @ResponseBody
    public String allA(){
        List<Account> accountList = accountService.findAllAccount();
        log.error(accountList);
        return "status: "+"200\r"+
                "message: "+"success\r"+
                "data: "+accountList;
    }
    //根据账户名查询用户  要求用表单传参
    @RequestMapping(value = "Accounts/AccountsByName",method = RequestMethod.GET)
    @ResponseBody
    public String accountBN(@RequestBody String account_name){
//        String account_name = account.getAccount_name();
//        log.error(account);
        log.error(account_name);
        List<Account> accountList = accountService.findByName(account_name);
        log.error(account_name);
        return "status: "+"200\r"+
                "message: "+"success\r"+
                "data: "+accountList;
    }
    //根据角色查询用户
    @RequestMapping(value = "Accounts/AccountsByRole",method = RequestMethod.GET)
    @ResponseBody
    public String accountBR(@RequestBody String role){
        List<Account> accountList = accountService.findByRole(role);
        log.error(accountList);
        return "status: "+"200\r"+
                "message: "+"success\r"+
                "data: "+accountList;
    }
    //删除用户
    @RequestMapping(value = "Accounts/LesserAccounts",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserA(@RequestBody Long id){
        List<Account> accountList = accountService.findAllAccount();
        accountService.deleteAccount(id);
        List<Account> accountList1 = accountService.findAllAccount();
        int flag = (accountList.size()-accountList1.size());
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
    //新增用户  校验器:密码六位以上 三个栏位不为空 账户名不重复
    @RequestMapping(value = "Accounts/MoreAccounts",method = RequestMethod.POST)
    @ResponseBody
    public String moreA(HttpServletRequest request,
                        @Validated Account account,
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
        account.setUpdate_at(System.currentTimeMillis());
        log.error("新增的数据 : "+account);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + accountService.insertAccount(account);
    }
    //编辑用户  逻辑同上
    @RequestMapping(value = "Accounts/AccountsInfo",method = RequestMethod.PUT)
    @ResponseBody
    public String accountI(HttpServletRequest request,
                        @Validated Account account,
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
        account.setUpdate_at(System.currentTimeMillis());
        Account account1 = accountService.findById(account.getId());
        accountService.updateAccount(account);
        log.error("修改的数据 : "+account);
        return "status: " + "200\r" +
                "message: " + "success\r" +
                "data: " + true;
    }
}
