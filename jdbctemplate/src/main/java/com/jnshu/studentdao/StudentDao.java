package com.jnshu.studentdao;

import com.jnshu.student.Student;

import javax.sql.DataSource;

public interface StudentDao {
    public void setDataSource(DataSource dataSource);
    public void insert(Student student) ;
    public boolean delete(String name);
    public boolean update(String name,String wish);
    public Student selectById(int id);
    public Student selectByName(String name);
    /*public void insertReturnId(Student student);*/
//    public  selectAll();
}
