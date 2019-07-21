package com.jnshu.studentdaoimpl;

import com.jnshu.student.Student;
import com.jnshu.studentdao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class StudentDaoImpl implements StudentDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate =
                new JdbcTemplate(dataSource);
    }

    public void insert(Student student) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext
                        ("applicationContext.xml");
        StudentDaoImpl studentDaoImpl =
                (StudentDaoImpl) context.getBean("studentDaoImpl");
        String SQL = "insert into student (name,major,admission_time," +
                "graduate_school,online_id,diary_link,wish,guide,create_time,update_time)" +
                "values (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL,student.getName(),student.getMajor()
        ,student.getAdmission_time(),student.getGraduate_school(),student.getOnline_id()
        ,student.getDiary_link(),student.getWish(),student.getGuide(),
                student.getCreate_time(),student.getUpdate_time());
        Student student1 = studentDaoImpl.selectByName(student.getName());
        System.out.println(student1.getId());

    }
    //试图实现插入单条数据后返回他的ID,不成功
    /*public void insertReturnId(Student student){
        String SQL = "insert into student (name,major,admission_time," +
                "graduate_school,online_id,diary_link,wish,guide,create_time,update_time)" +
                "values (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(SQL,student.getName(),student.getMajor()
                ,student.getAdmission_time(),student.getGraduate_school(),student.getOnline_id()
                ,student.getDiary_link(),student.getWish(),student.getGuide(),
                student.getCreate_time(),student.getUpdate_time());
        System.out.println("insert ok");
        String SQL2 = "select * from student where online_id = ?";
        Student student2 = jdbcTemplate.queryForObject
                (SQL,new StudentRowMapper(),id);
        System.out.println("map ok");
        System.out.println(student2.getId());
    }*/

    public boolean delete(String name){
        String SQL = "delete from student1 where name = ?";
        int result = jdbcTemplate.update(SQL,name);
        return true;

    }
    public boolean update(String name,String wish){
        String SQL = "update student set wish = ? where name = ?";
        int result = jdbcTemplate.update(SQL,wish,name);
        return true;
    }
    public Student selectById(int id){
        String SQL = "select * from student where id = ?";
        Student student = jdbcTemplate.queryForObject
                (SQL,new StudentRowMapper(),id);
        System.out.println(student);
        return student;
    }
    public Student selectByName(String name){
        String SQL = "select * from student where name = ?";
        Student student =jdbcTemplate.queryForObject
                (SQL,new StudentRowMapper(),name);
        System.out.println(student);
        return student;
    }
    /*public void selectAll(){
        String SQL = "select * from student1";
        jdbcTemplate.queryForList(SQL,new StudentRowMapper());
    }*/

}
