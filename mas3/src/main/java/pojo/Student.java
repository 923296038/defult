package pojo;

public class Student {
    private String name;
    private String sex;
    private int age;
    private int id;
    private String school;

    public Student() {
    }

    public Student(String name, String sex, int age, int id, String school) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.id = id;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    //重写toString方法.返回学生信息
    public String toString() {
        return "POJO.Student[name "+name+" ,sex "+sex+" ,age "+age+" ,school "+school+"]";
    }
}
