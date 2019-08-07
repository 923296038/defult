package com.serviceImpl;

import com.mapper.StudentMapper;
import com.service.StudentService;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public boolean deleteStudent(long id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public List <Student> findStudentByName(String name) {
        return studentMapper.findStudentByName(name);
    }


    @Override
    public  Student findStudentById(long id){
        return studentMapper.findStudentById(id);
    }



    @Override
    public List<Student> findAllStudent() {
        return studentMapper.findAllStudent();}
}