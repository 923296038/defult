package com.jnshu.client;

import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    private static final Logger log= LogManager.getLogger(Client.class);
    public static void main(String[] args) {
        ApplicationContext context=new
                ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService= (StudentService) context.getBean("studentService");
        Student student =new Student();
        student.setOnline_id(13);
        student.setWish("6666");
        student.setName("cym");
        studentService.insertStudent(student);
        /*log.info("insert 'cym'");*/
        /*studentService.queryStudentByName("wangquan");
        studentService.queryStudentByID(24);*/
        /*studentService.deleteStudent("cym");*/
        /*log.info("delete 'wangquan'");*/
        student.setWish("9999");
        studentService.updateStudent(student);
        log.info("update wish");

    }
}
