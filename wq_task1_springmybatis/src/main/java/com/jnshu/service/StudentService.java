package com.jnshu.service;

import com.jnshu.pojo.Student;

public interface StudentService {
    public int insertStudent(Student student);
    public int insertStudentReturnId(Student student);
    public int deleteStudent(String name);
    public int updateStudent(Student student);
    /*public Student queryStudentByName(String name);*/
    public Student queryStudentByName(String name);
    public Student queryStudentByID(int id);


}
