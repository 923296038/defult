package com.jnshu.serviceimpl;

import com.jnshu.client.Client;
import com.jnshu.mapper.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*业务层的实现类,其中的注解注入不理解*/
@Service(value = "studentService")
//@Service注解
public class StudentServiceImpl implements StudentService {
    @Autowired  //
    StudentMapper studentMapper;
    private static final Logger log= LogManager.getLogger(Client.class);
    @Autowired
    //构造器
    public StudentServiceImpl(StudentMapper studentMapper)
    {this.studentMapper=studentMapper;}


    @Override
    public int insertStudent(Student student){
        studentMapper.insertStudent(student);
        return student.getId();
    }
    @Override
    //插入一条数据,返回他的id
    public int insertStudentReturnId(Student student){
        studentMapper.insertStudent(student);
        studentMapper.queryStudentByOnline_Id(student.getOnline_id());
        log.info(student.getId());
        return student.getId();
    }
    @Override
    public int deleteStudent(String name) {
        int result = studentMapper.deleteStudent(name);
        boolean flag = result>0?true:false;
        log.info(flag);
        return result;
    }

    @Override
    public int updateStudent(Student student) {
        int result = studentMapper.updateStudent(student);
        boolean flag = result>0?true:false;
        log.info(flag);
        return result;
    }

    /*//这个方法并不能打印所查询的信息
    @Override
    public Student queryStudentByName(String name) {
        return studentMapper.queryStudentByName(name);
    }*/
    @Override
    public Student queryStudentByName(String name) {
        Student student = studentMapper.queryStudentByName(name);
        log.info(student);
        return student;
    }

    @Override
    public Student queryStudentByID(int id) {
        Student student = studentMapper.queryStudentById(id);
        log.info(student);
        return student;
    }

}
