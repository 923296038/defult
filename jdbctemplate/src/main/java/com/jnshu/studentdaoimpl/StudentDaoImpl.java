package com.jnshu.studentdaoimpl;

import com.jnshu.student.Student;
import com.jnshu.studentdao.StudentDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class StudentDaoImpl implements StudentDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private static final Logger log= LogManager.getLogger(StudentDaoImpl.class);

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate =
                new JdbcTemplate(dataSource);
    }
    //插入能返回id.但会把插入成员的全部信息都打印出来
    public void insertReturnAll(Student student) {
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
        //System.out.println(student1.getId());
        //log.info(student1.getId());
    }

    public void insertReturnId(Student student){
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
        studentDaoImpl.returnId(student.getOnline_id());
    }

    public void returnId(long online_id){
        String SQL = "select * from student where online_id = ?";
        Student student = jdbcTemplate.queryForObject
                (SQL,new StudentRowMapper(),online_id);
        log.info(student.getId());
    }

    public boolean delete(String name){
        String SQL = "delete from student where name = ?";
        int result = jdbcTemplate.update(SQL,name);
        boolean flag = result>0?true:false;
        log.info(flag);
        return flag;

    }
    public boolean update(String name,String wish){
        String SQL = "update student set wish = ? where name = ?";
        int result = jdbcTemplate.update(SQL,wish,name);
        boolean flag = result>0?true:false;
        log.info(flag);
        return flag;
    }
    public Student selectById(int id){
        String SQL = "select * from student where id = ?";
        Student student = jdbcTemplate.queryForObject
                (SQL,new StudentRowMapper(),id);

        log.info(student);
        return student;
    }
    public Student selectByName(String name){
        String SQL = "select * from student where name = ?";
        Student student =jdbcTemplate.queryForObject
                (SQL,new StudentRowMapper(),name);
        log.info(student);
        return student;
    }
    /*public void selectAll(){
        String SQL = "select * from student1";
        jdbcTemplate.queryForList(SQL,new StudentRowMapper());
    }*/

}
