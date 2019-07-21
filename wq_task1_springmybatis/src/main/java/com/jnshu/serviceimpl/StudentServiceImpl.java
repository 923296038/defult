package com.jnshu.serviceimpl;

import com.jnshu.mapper.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*业务层的实现类,其中的注解注入不理解*/
@Service(value = "studentService")
//@Service注解
public class StudentServiceImpl implements StudentService {
    @Autowired  //
    StudentMapper studentMapper;
    @Autowired
    //构造器
    public StudentServiceImpl(StudentMapper studentMapper)
    {this.studentMapper=studentMapper;}


    @Override
    public void insertStudent(Student student){
        studentMapper.insertStudent(student);

    }

    @Override
    public boolean deleteStudent(String name) {
        studentMapper.deleteStudent(name);
        return true;
    }

    @Override
    public boolean updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return true;
    }

    /*//这个方法并不能打印所查询的信息
    @Override
    public Student queryStudentByName(String name) {
        return studentMapper.queryStudentByName(name);
    }*/
    @Override
    public void queryStudentByName(String name) {
        Student student = studentMapper.queryStudentByName(name);
        System.out.println(student);
    }

    @Override
    public void queryStudentByID(int id) {
        Student student = studentMapper.queryStudentById(id);
        System.out.println(student);
    }
}
