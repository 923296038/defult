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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        return "Account List :"+accountList;
    }
    //根据账户名查询用户
    @RequestMapping(value = "Accounts/AccountByName",method = RequestMethod.GET)
    @ResponseBody
    public String accountBN(String account_name){
        List<Account> accountList = accountService.findByName(account_name);
        log.error(accountList);
        return "query by account name result : "+accountList;
    }
    //根据角色查询用户
    @RequestMapping(value = "Accounts/AccountByRole",method = RequestMethod.GET)
    @ResponseBody
    public String accountBR(String role){
        List<Account> accountList = accountService.findByRole(role);
        log.error(accountList);
        return "query by role : "+accountList;
    }
    //删除用户
    @RequestMapping(value = "Accounts/LesserAccounts",method = RequestMethod.DELETE)
    @ResponseBody
    public String lesserA(Long id){
        List<Account> accountList = accountService.findAllAccount();
        accountService.deleteAccount(id);
        List<Account> accountList1 = accountService.findAllAccount();
        log.error("删除了 "+(accountList.size()-accountList1.size())+" 条数据");
        return "deleted "+(accountList.size()-accountList1.size())+" record";
    }
    //新增用户  校验器:密码六位以上 三个栏位不为空
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
            return "error ! "+allErrors;
        }
        account.setUpdate_at(System.currentTimeMillis());
        accountService.insertAccount(account);
        log.error("新增的数据 : "+account);
        return "new account : " +account;
    }
    //编辑用户  逻辑同上
    @RequestMapping(value = "Accounts/AccountInfo",method = RequestMethod.PUT)
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
            return "error ! "+allErrors;
        }
        account.setUpdate_at(System.currentTimeMillis());
        Account account1 = accountService.findById(account.getId());
        accountService.updateAccount(account);
        log.error("修改的数据 : "+account);
        return "previous account : "+account1+"; new account : " +account;
    }
}
