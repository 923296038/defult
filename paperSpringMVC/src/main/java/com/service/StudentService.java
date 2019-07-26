package com.service;

import com.pojo.Student;

import java.util.List;


public interface StudentService {
    //添加学生数据
    int insertStudent(Student student);
    //根据名字删除学生数据
    boolean deleteStudent(long id);
    //更新学生数据
    boolean updateStudent(Student student);
    //根据姓名查询学生数据
    List<Student> findStudentByName(String name);
    //根据ID查询学生数据
    Student findStudentById(long id);
    //查询所有学生数据
    List<Student> findAllStudent();

}
