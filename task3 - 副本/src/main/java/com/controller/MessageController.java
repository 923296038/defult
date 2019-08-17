package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Message;
import com.service.MessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    MessageService messageService;
    private static final Logger log= LogManager.getLogger(MessageController.class);
    //留言列表
    @RequestMapping(value = "Messages/AllMessages",method = RequestMethod.GET)
    @ResponseBody
    public String findAllM(){
        List<Message> messageList = messageService.findAllMessage();
        log.error(messageList);
        return ""+messageList;
    }
    //根据作品查询留言
    @RequestMapping(value = "Messages/MessageByName",method = RequestMethod.GET)
    @ResponseBody
    public String MessageBN(HttpServletRequest request,String work_title,
                            @Validated Message message,BindingResult bindingResult){
        if(work_title.length()==0&&bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError:allErrors){
                log.error(objectError.getDefaultMessage());
            }
            return ""+allErrors;
        }
        List<Message> messageList = messageService.findByWorkTitle(work_title);
        log.error(messageList);
        return ""+messageList;
    }
    //前往编辑留言
    /*@RequestMapping(value = "Messages/toMessageInfo/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String toMI(Model model, @PathVariable Long id){
        Message message= messageService.findByID(id);
        model.addAttribute("message",message);
        return "MessageInfo";
    }*/

    //编辑留言
    /*@RequestMapping(value = "StudentInfo",
            method = RequestMethod.POST)
    public String updateStudent(Model model, Message message){

        message.setUpdate_at(System.currentTimeMillis());

    }*/
    //设为精选
    @RequestMapping(value = "Messages/Selected",method = RequestMethod.POST)
    @ResponseBody
    public String selected(Long id){
        messageService.upMessage(id);
        log.error("执行了精选"+id);
        return "selected :" + id;
    }
    //取精
    @RequestMapping(value = "Messages/unSelected",method = RequestMethod.POST)
    @ResponseBody
    public String unSelected(Long id){
        messageService.downMessage(id);
        log.error("unSelected"+id);
        return "unselected : " + id;
    }
    //前往回复留言
    /*@RequestMapping(value = "Messages/toResponse/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String toResp(Model model,@PathVariable Long id){
        Message message= messageService.findByID(id);
        log.error(message);
        model.addAttribute("message",message);
        return "message/ReplyMessage";
    }*/
    //回复留言
    @RequestMapping(value = "Messages/Response",method = RequestMethod.POST)
    @ResponseBody
    public String response(Message message){
        message.setUpdate_at(System.currentTimeMillis());
        messageService.updateReply(message);
        //同时设为精选留言
        messageService.upMessage(message.getId());
        Message message1 =messageService.findByID(message.getId());
        return "MessageInfo"+message1;
    }
    //前往删除留言
    /*@RequestMapping(value = "Messages/toLesserMessages/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String toLM(Model model,@PathVariable Long id){
        log.error("删除前,id:"+id);
        Message message = messageService.findByID(id);
        model.addAttribute("message",message);
        return "message/MesDelConfirm";
    }*/
    //确定删除留言
    @RequestMapping(value = "Messages/LesserMessages",
            method = RequestMethod.DELETE)
    @ResponseBody
    public String LesserM(Long id){
        log.error("执行了删除方法,id:"+id);
        List<Message> messageList = messageService.findAllMessage();
        messageService.deleteMessage(id);
        List<Message> messageList1 = messageService.findAllMessage();
        log.error("deleted"+(messageList.size()-messageList1.size())+"record");
        return "deleted "+(messageList.size()-messageList1.size())+" record";
    }
}
