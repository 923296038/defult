package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Message;
import com.pojo.Module;
import com.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;
    private static final Logger log= LogManager.getLogger(MessageController.class);
    //留言列表
    @RequestMapping(value = "Messages/AllMessages",method = RequestMethod.GET)
    public String findAllM(Model model,@RequestParam(defaultValue = "1",required = true,
            value = "pageNo") Integer pageNo){
        Integer pageSize=5;
        PageHelper.startPage(pageNo,pageSize);
        List<Message> messageList = messageService.findAllMessage();
        PageInfo<Message> pageInfo = new PageInfo<>(messageList);
        model.addAttribute("pageInfo",pageInfo);
        return "AllMessages";
    }
    //根据作品查询留言
    //前往编辑留言
    @RequestMapping(value = "Messages/toMessageInfo/{id}",method = RequestMethod.GET)
    public String toMI(Model model, @PathVariable Long id){
        Message message= messageService.findByID(id);
        model.addAttribute("message",message);
        return "MessageInfo";
    }

    //编辑留言
//    @RequestMapping(value = "StudentInfo",
//            method = RequestMethod.POST)
//    public String updateStudent(Model model, Message message){
//
//        message.setUpdate_at(System.currentTimeMillis());
//
//    }
    //设为精选
    @RequestMapping(value = "Messages/Selected/{id}",method = RequestMethod.POST)
    public String selected(Model model,@PathVariable Long id){
        messageService.upMessage(id);
        log.error("执行了精选"+id);
        return "redirect:/Messages/AllMessages";
    }
    //取精
    @RequestMapping(value = "Messages/unSelected/{id}",method = RequestMethod.POST)
    public String unSelected(Model model,@PathVariable Long id){
        log.error("unSelected"+id);
        messageService.downMessage(id);
        return "redirect:/Messages/AllMessages";
    }
    //前往回复留言
    @RequestMapping(value = "Messages/toResponse/{id}",method = RequestMethod.GET)
    public String toResp(Model model,@PathVariable Long id){
        Message message= messageService.findByID(id);
        log.error(message);
        model.addAttribute("message",message);
        return "Response";
    }
    //回复留言
    @RequestMapping(value = "Messages/Response",method = RequestMethod.POST)
    public String response(Model model,Message message){
        messageService.updateReply(message);
        log.error(message);
        Message message1 =messageService.findByID(message.getId());
        log.error(message1);
        model.addAttribute("message",message1);
        return "MessageInfo";
    }
    //前往删除留言
    @RequestMapping(value = "Messages/toLesserMessages/{id}",method = RequestMethod.GET)
    public String toLM(Model model,@PathVariable Long id){
        log.error("删除前,id:"+id);
        Message message = messageService.findByID(id);
        model.addAttribute("message",message);
        return "Confirm";
    }
    //确定删除留言
    @RequestMapping(value = "Messages/LesserMessages/{id}",
            method = RequestMethod.DELETE)
    public String LesserM(@PathVariable Long id){
        log.error("执行了删除方法,id:"+id);
        messageService.deleteMessage(id);
        return "redirect:/Messages/AllMessages";
    }
}
