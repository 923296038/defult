package com.shsxt;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

//import org.springframework.jdbc.core.RowMapper;

public class StudentJDBCTemplate implements StudentDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name,Integer age){
        String SQL = "insert into Student(name,age) values (?,?)";
        jdbcTemplateObject.update(SQL,name,age);
        System.out.println("created record name=" +name+" age="+age);
        return;
    }
    public Student getStudent(Integer id){
        String SQL = "select * from Student where id = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, (RowMapper<Student>) new StudentMapper());
        return student;
    }
    public List<Student> listStudent(){
        String SQL = "select * from Student";
        List<Student> students = jdbcTemplateObject.query(SQL, (RowMapper<Student>) new StudentMapper());
        return students;
    }
    public void delete(Integer id){
        String SQL = "delete from Student where id = ?";
        jdbcTemplateObject.update(SQL,id);
        System.out.println("deleted record with id = " + id);
        return;
    }
    public void update(Integer id,Integer age){
        String SQL = "update Student set age = ? where id = ?";
        jdbcTemplateObject.update(SQL,age,id);
        System.out.println("updated record with id = "+id);
        return;
    }
}
