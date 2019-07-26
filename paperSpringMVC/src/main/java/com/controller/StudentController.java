package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.StudentService;
import com.pojo.Student;
import org.junit.jupiter.api.Test;
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
import org.springframework.web.servlet.ModelAndView;

import java.lang.annotation.Target;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    /**
     * 跳转到学生添加界面
     */
    @RequestMapping(value = "/toAddStudent")
    public String toAddStudent(){
        return "addStudent";
    }
    /**
     * 添加学生
     */
    @RequestMapping(value="/addStudent2",method = RequestMethod.POST)
    public String addStudent( Model model,Student student){
        studentService.insertStudent(student);
        model.addAttribute("student",student);
        return "redirect:/findAllStudent";
    }

    @RequestMapping(value = "/addStudent")
    public ModelAndView addStudent(Student student) {
        studentService.insertStudent(student);
        ModelAndView mav = new ModelAndView
                ("redirect:/findAllStudent");
        return mav;
    }

    /**
     参数model是什么意思?
     */
    @RequestMapping(value="/toUpdateStudent/{id}",
            method = RequestMethod.GET)
    public String toUpdateStudent
            (Model model,@PathVariable long id){
        //先获得原数据才能更改
        Student student=studentService.findStudentById(id);
        //model.addAttibute 往前台传数据
        model.addAttribute("student",student);
        return "updateStudent";
    }

    @RequestMapping(value = "/updateStudent",
            method = RequestMethod.POST)
    public String updateStudent(Student student){
        studentService.updateStudent(student);
        return "redirect:/findAllStudent";
    }

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
        //提交到前台,视图层才能显示数据
        model.addAttribute(studentList);
        return "select";
    }

    @RequestMapping(value = "/deleteStudent/{id}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable long id,@Validated Student student,BindingResult result){
        studentService.deleteStudent(id);
        return "redirect:/findAllStudent";
    }

    @RequestMapping(value = "/findAllStudent", method =RequestMethod.GET)
    public String findAllStudent(Model model, @RequestParam(defaultValue = "1",required = true,value = "pageNo")Integer pageNo)  {
        Integer pageSize=5;//每页显示记录数为5
        PageHelper.startPage(pageNo,pageSize);
        List<Student>studentList=studentService.findAllStudent();//获取所有用户信息
        PageInfo<Student>pageInfo=new PageInfo<Student>(studentList);
        model.addAttribute("pageInfo",pageInfo);
        return "studentInfo";
    }

}