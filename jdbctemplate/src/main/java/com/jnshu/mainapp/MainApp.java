package com.jnshu.mainapp;

import com.jnshu.student.Student;
import com.jnshu.studentdaoimpl.StudentDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.Beans;

public class MainApp {
    public static void main(String[] args) {
        Logger log = LogManager.getLogger("AsyncFileLogger");
        ApplicationContext context =
                new ClassPathXmlApplicationContext
                        ("applicationContext.xml");
        StudentDaoImpl studentDaoImpl =
                (StudentDaoImpl) context.getBean("studentDaoImpl");

        Student student = new Student("chen","python",2019,
                "hbpu",6026,"#","#","wang",1,1);
        studentDaoImpl.insert(student);
        log.info("insert ok");
        studentDaoImpl.selectByName("chen");
        studentDaoImpl.update("chen","wq666");
        log.info("updatewish ok");

    }
}
