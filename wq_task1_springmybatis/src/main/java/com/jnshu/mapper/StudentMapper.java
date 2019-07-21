package com.jnshu.mapper;

import com.jnshu.pojo.Student;

public interface StudentMapper {
    int insertStudent(Student student);
    boolean deleteStudent(String name);
    boolean updateStudent(Student student);

    Student queryStudentById(int id);
    Student queryStudentByName(String name);
}
