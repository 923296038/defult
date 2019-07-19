package com.jnshu.studentdaoimpl;

import com.jnshu.student.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    public Student mapRow
            (ResultSet rs,int rouNum) throws SQLException{
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setMajor(rs.getString("major"));
        student.setAdmission_time(rs.getLong("admission_time"));
        student.setGraduate_school(rs.getString("graduate_school"));
        student.setOnline_id(rs.getInt("online_id"));
        student.setDiary_link(rs.getString("diary_link"));
        student.setWish(rs.getString("wish"));
        student.setGuide(rs.getString("guide"));
        student.setCreate_time(rs.getLong("create_time"));
        student.setUpdate_time(rs.getLong("update_time"));
        return student;
    }
}
