import com.jnshu.student.Student;
import com.jnshu.studentMapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.Reader;

public class TestMybatis {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private static final Logger log= LogManager.getLogger(TestMybatis.class);
    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    @Test
    //增加一个用户返回id
    public void addUser() {
        Student student = new Student();
        student.setWish("place");
        student.setName("test_add");
        student.setOnline_id(304);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper userOperation = session
                    .getMapper(StudentMapper.class);
            userOperation.addUser(student);
            session.commit();
            log.info("新增用户ID：" + student.getId());
        } finally {
            session.close();
        }
    }
    @Test
    //更改立愿
    public void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper userOperation = session
                    .getMapper(StudentMapper.class);
            Student student = userOperation.selectUserByID(50);
            if (student != null) {
                student.setWish("写代码");
                int result = userOperation.updateUser(student);
                session.commit();
                boolean flag = result>0?true:false;
                log.info(flag);
            }
            else {
                log.info("false");
            }
        } finally {
            session.close();
        }
    }
    @Test
    //根据id查询
    public void getUserByID() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper userOperation = session.getMapper(StudentMapper.class);
            //session.getMapper()的作用.已知Mapper为映射器.
            Student student = userOperation.selectUserByID(50);
            if (student != null) {
                log.info(student.toString());
            }
        } finally {
            session.close();
        }
    }
    @Test
    //根据姓名查询
    public void getUserByName(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper userOperation = session.getMapper(StudentMapper.class);
            //session.getMapper()的作用.已知Mapper为映射器.
            Student student = userOperation.selectUsersByName("test_add");
            if (student != null) {
                log.info(student.toString());
            }
        } finally {
            session.close();
        }
    }
    @Test
    //根据id删除数据
    public void deleteUser() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper userOperation = session
                    .getMapper(StudentMapper.class);
            int result = userOperation.deleteUser(50);
            session.commit();
            boolean flag = result>0?true:false;
            log.info(flag);
        } finally {
            session.close();
        }
    }
}
