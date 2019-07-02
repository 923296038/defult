package com.shsxt;

//import javax.swing.tree.RowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    public Student mapRow(ResultSet rs,int rouNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("ID"));
        student.setName(rs.getString("name"));
        student.setAge(rs.getInt("age"));
        return student;
    }
}
