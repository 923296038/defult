import dao.StudentDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

public class StudentDaoImpTest {
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }

    @Test
    public void insertStudent() {
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        //
        Student student = new Student("wang", "male", 14, 66, "primary school");
        int result = studentDao.insertStudent(student);
        boolean flag = result > 0 ? true : false;
        /*studentDao.updateStudent(student);*/
        System.out.println("insert result :" + flag);
    }

    @Test
    public void deleteStudent() {
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        Student student = new Student();
        student.setName("我啊啊");
        int result = studentDao.deleteStudent(student.getName());
        boolean flag = result > 0 ? true : false;
        System.out.println("delete result :" + flag);

    }

    @Test
    public void updateStudent() {
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        Student student = new Student();
        student.setSchool("厦门大学");
        student.setId(2133);
        int result = studentDao.updateStudent(student);
        if (result >= 0) {
            System.out.println("update succussed");
        }
    }

    @Test
    public void findStudentById() {
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        Student student = new Student();
        student.setId(2133);
        System.out.println(studentDao.findStudentById(student.getId()));
    }

    @Test
    public void findAllStudent() {
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        System.out.println(studentDao.findAllStudent());

    }
}
