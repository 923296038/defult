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
    public void insert(){
        Student student =new Student();
        student.setOnline_id(1181);
        student.setWish("6666");
        student.setName("wangquan");
        studentService.insertStudent(student);
    }
    @Test
    public void queryByName() {
        studentService.queryStudentByName("wangquan");
    }
    @Test
    public void update(){
        Student student =new Student();
        student.setWish("9999");
        studentService.updateStudent(student);
    }
    @Test
    public void delete(){
        studentService.deleteStudent("wangquan");
    }
}
