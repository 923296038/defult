import com.controller.StudentController;
import com.pojo.Student;
import com.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

public class test {
    private static final Logger log= LogManager.getLogger(test.class);
    @Autowired
    StudentService studentService;
    @Test
    public void testInsert(){
        Student student1 = new Student("insert",123,"java",201907,"hbpu",
                "jnshu.com","6","lwc","zhihu",803,803);
        studentService.insertStudent(student1);
    }
    @Test
    public void testDelete(){
        studentService.deleteStudent(102);
    }
    @Test
    public void testUpdate(){
        Student student1 = new Student("update_ok",123,"java",201907,
                "hbpu",108,
                "jnshu.com","6","lwc","zhihu",803,803);
        studentService.updateStudent(student1);
    }
    @Test
    public void testQuery(){
        List<Student>studentList=studentService.findStudentByName("insert");
        log.error(studentList);
    }
}
