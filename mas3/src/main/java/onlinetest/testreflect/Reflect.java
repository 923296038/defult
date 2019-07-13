package onlinetest.testreflect;

import dao.StudentDao;
import pojo.Student;

public class Reflect {
    public static void main(String[] args) {
        Student stu1 = new Student();
        Class stuClass = stu1.getClass();
        //*object*.getClass()
        System.out.println(stuClass.getName());
        Class stuClass2 = Student.class;
        //*class*.class
        System.out.println(stuClass2.getName());
        //Class.forName("*classpath*")
        try {
            Class stuClass3 = Class.forName("pojo.Student");
            System.out.println(stuClass3.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
