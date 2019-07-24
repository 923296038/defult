package com.jnshu.controller;

/*import com.github.p*//*agehelper.PageHelper;
import com.jnshu.service.UserService;
import com.task.Service.StudentService;
import com.task.pojo.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import com.jnshu.service.UserService;
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

import java.util.List;

@Controller
public class UserController {
//    @Autowired
//    UserService userService;
    /*private static final Logger logger= LogManager.getLogger(StudentController.class);
    *//**
     * 跳转到学生添加界面
     *//*
    @RequestMapping(value = "/toAddStudent")
    public String toAddStudent(){
        return "add";
    }
    *//**
     * 添加学生
     *//*
    @RequestMapping(value="/addStudent",method = RequestMethod.POST)
    public String addStudent( Model model,Student student){
        studentService.insertStudent(student);
        model.addAttribute("student",student);
        return "redirect:/findAllStudent";

    }
    *//**
     * 跳转到学生更新界面
     * @param model
     * @param id
     * @return
     *//*
    @RequestMapping(value="/toUpdateStudent/{id}",method = RequestMethod.GET)
    public String toUpdateStudent(Model model,@PathVariable long id){
        Student student=studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "edit";
    }
    *//**
     * 更新学生数据
     *//*
    @RequestMapping(value="/updateStudent",method = RequestMethod.POST)
    public String updateStudent(Model model,Student student){
        if (studentService.updateStudent(student)){
            student=studentService.findStudentById(student.getId());
            model.addAttribute("student",student);
            return "redirect:/findAllStudent";
        }
        return "error";
    }

    *//**
     * 根据姓名查询学生
     *//*
    @RequestMapping(value="/findStudent",method = RequestMethod.GET)
    public String findStudent(Model model, String name, @Validated Student student, BindingResult result){
        if (name==null && result.hasErrors()){
            List<ObjectError>allErrors=result.getAllErrors();
            for (ObjectError objectError:allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }
            model.addAttribute("errors",allErrors);
            return "error";
        }
        List<Student> studentList=studentService.findStudentByName(name);
        System.out.println(studentList);
        model.addAttribute(studentList);
        return "select";
    }

    *//**
     * 根据id删除学生
     *//*
    @RequestMapping(value = "/deleteStudent/{id}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable long id,@Validated Student student,BindingResult result){
        studentService.deleteStudent(id);
        return "redirect:/findAllStudent";
    }

    *//**
     * 查询学生所有数据
     *//*
    //分页查询
    @RequestMapping(value = "/findAllStudent", method =RequestMethod.GET)
    public String findAllStudent(Model model, @RequestParam(defaultValue = "1",required = true,value = "pageNo")Integer pageNo)  {
        Integer pageSize=5;//每页显示记录数为5
        PageHelper.startPage(pageNo,pageSize);
        List<Student>studentList=studentService.findAllStudent();//获取所有用户信息
        PageInfo<Student>pageInfo=new PageInfo<Student>(studentList);
        model.addAttribute("pageInfo",pageInfo);
        return "studentInfo";
    }*/

    /*我的改写*/
    @RequestMapping(value = "/jump",method = RequestMethod.GET)
    public String  jump(){
        return "reach";
    }
}