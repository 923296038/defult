package dao;

import pojo.Student;
import java.util.List;

public interface StudentDao {
    public int insertStudent(Student student);
    public int deleteStudent(String name);
    public int updateStudent(Student student);
    public Student findStudentById(long id);
    public List<Student> findAllStudent();
}
