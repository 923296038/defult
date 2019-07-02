package com.shsxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
        System.out.println("--Records Creation--");
        studentJDBCTemplate.create("wangquan",21);
        studentJDBCTemplate.create("chenyumeng",22);
        studentJDBCTemplate.create("chenyiming",7);
        System.out.println("--listing multiple records");
        List<Student> students = studentJDBCTemplate.listStudent();
        for (Student record : students){
            System.out.println("ID:"+record.getId());
            System.out.println(",name:"+record.getName());
            System.out.println(",age:"+record.getAge());
        }
        System.out.println("--updating record with id = 2");
        studentJDBCTemplate.update(2,20);
        System.out.println("--listing record with id = 2");
        Student student = studentJDBCTemplate.getStudent(2);
        System.out.println("ID:"+student.getId()+",name:"+student.getName()+",age:"+student.getAge());
        //System.out.println(",name:"+student.getName());
        //System.out.println(",age:"+student.getAge());
    }
}
