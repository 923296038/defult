import com.jnshu.student.Student;
import com.jnshu.studentdaoimpl.StudentDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class testjunit {

        ApplicationContext context =
                new ClassPathXmlApplicationContext
                        ("applicationContext.xml");
        StudentDaoImpl studentDaoImpl =
                (StudentDaoImpl) context.getBean("studentDaoImpl");

    @Test
    public void insert(){
        Student student = new Student("chen","python","2019",
                "hbpu",6026,"#","#","wang","1","1");
        studentDaoImpl.insert(student);
    }
    @Test
    public void update(){
        studentDaoImpl.update("chen","wqis");
    }
    @Test
    public void query(){
        studentDaoImpl.selectByName("chen");
    }
    @Test
    public void delete(){
        studentDaoImpl.delete("chen");
    }
}
