package com.jnshu.studentdao;

import com.jnshu.student.Student;
import com.jnshu.studentdaoimpl.StudentRowMapper;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.sql.DataSource;

public interface StudentDao {
    public void setDataSource(DataSource dataSource);
    public void insert(Student student) ;
    public int delete(String name);
    public int update(String name,String wish);
    public void selectById(int id);
    public void selectByName(String name);
    /*public void insertReturnId(Student student);*/
//    public  selectAll();
}
