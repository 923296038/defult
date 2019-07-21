package com.jnshu.studentMapper;

import com.jnshu.student.Student;

import java.util.List;

public interface StudentMapper {

    public Student selectUserByID(int id);
    public Student selectUsersByName(String name);
    public Student selectUsersById(int id);

    public int addUser(Student student);

    public int updateUser(Student student);

    public int deleteUser(int id);

}