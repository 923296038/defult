package com.jnshu.service;

import com.jnshu.pojo.Student;

public interface StudentService {
    public void insertStudent(Student student);
    public boolean deleteStudent(String name);
    public boolean updateStudent(Student student);
    /*public Student queryStudentByName(String name);*/
    public void queryStudentByName(String name);
    public void queryStudentByID(int id);

}
