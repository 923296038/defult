package onlinetest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    public void addUser(){
        System.out.println("add a user hiahia");
    }

    public static void main(String[] args){
        //1 获得容器
        String xmlPath="com/itheima/a_ioc/beans.xml";
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("testioc1.xml");
        //2获得内容 --不需要自己new，都是从spring容器获得
        UserService userService2 = new UserServiceImpl();
        //传统方法,new对象
        UserService userService=(UserService)applicationContext.getBean("userServiceId");
        //让Spring帮忙生成对象
        userService.addUser();
        userService2.addUser();
    }
}

