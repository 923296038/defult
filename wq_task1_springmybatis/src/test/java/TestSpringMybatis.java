import com.jnshu.client.Client;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMybatis {
    private static final Logger log= LogManager.getLogger(Client.class);
    ApplicationContext context=new
            ClassPathXmlApplicationContext("applicationContext.xml");
    StudentService studentService= (StudentService) context.getBean("studentService");
    @Test
    //测试插入一条数据,但不打印信息
    public void insert(){
        Student student =new Student();
        student.setOnline_id(1181);
        student.setWish("6666");
        student.setName("wangquan");
        studentService.insertStudent(student);
    }
    @Test
    //测试插入一条数据后返回它的id
    public void insertReturnId(){
        Student student =new Student();
        student.setOnline_id(11814);
        student.setWish("6666");
        student.setName("wangquan");
        studentService.insertStudentReturnId(student);
    }
    @Test
    //测试根据名字查询
    public void queryByName() {
        studentService.queryStudentByName("wangquan");
    }
    @Test
    //测试根据id查询
    public void queryById(){studentService.queryStudentByID(30);}
    @Test
    //测试修改立愿
    public void update(){
        Student student =new Student();
        student.setName("wangquan");
        student.setWish("666");
        studentService.updateStudent(student);
    }
    @Test
    //测试根据姓名删除某些数据
    public void delete(){
        studentService.deleteStudent("wangquan");
    }
}
