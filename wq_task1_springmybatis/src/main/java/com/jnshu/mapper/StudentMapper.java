package com.jnshu.mapper;

import com.jnshu.pojo.Student;

public interface StudentMapper {
    int insertStudent(Student student);
    int deleteStudent(String name);
    int updateStudent(Student student);

    Student queryStudentById(int id);
    Student queryStudentByName(String name);
    Student queryStudentByOnline_Id(long online_id);
}
