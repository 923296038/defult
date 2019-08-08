package com.pojo;

//import org.hibernate.validator.constraints.NotBlank;
//
//import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
    /**
     @NotEmpty 用在集合类上面
     @NotBlank 用在String上面
     @NotNull 用在基本类型上
     */
//    @NotBlank(message = "学生姓名不能为空")

    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotNull(message = "学号不为空")
    private long student_id;
    private long qq;
    private String learn_type;
    private long entrance_time;
    private String school;
//    @NotNull(message = "请填写id")
    private long id;
    private String daily_link;
    private String wish;
    private String senior;
    private String way;
    private long create_time;
    private long update_time;

    public Student() {
    }

    public Student(String name, long student_id, long qq, String learn_type, long entrance_time, String school, String daily_link, String wish, String senior, String way, long create_time, long update_time) {
        this.name = name;
        this.student_id = student_id;
        this.qq = qq;
        this.learn_type = learn_type;
        this.entrance_time = entrance_time;
        this.school = school;
        this.daily_link = daily_link;
        this.wish = wish;
        this.senior = senior;
        this.way = way;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public Student(String name, long student_id,long qq, String learn_type, long entrance_time, String school, long id, String daily_link, String wish, String senior, String way, long create_time, long update_time) {
        this.name = name;
        this.student_id = student_id;
        this.qq = qq;
        this.learn_type = learn_type;
        this.entrance_time = entrance_time;
        this.school = school;
        this.id = id;
        this.daily_link = daily_link;
        this.wish = wish;
        this.senior = senior;
        this.way = way;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getLearn_type() {
        return learn_type;
    }

    public void setLearn_type(String learn_type) {
        this.learn_type = learn_type;
    }

    public long getEntrance_time() {
        return entrance_time;
    }

    public void setEntrance_time(long entrance_time) {
        this.entrance_time = entrance_time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Student[name " + name + " ,qq " + qq + " ,learn_type " + learn_type + " ,entrance_time" + entrance_time +
                ",school" + school + ",id" + id + ",daily_link" + daily_link + ",wish" + wish + ",senior" + senior + ",way" + way + ",create_time" + create_time +
                ",update_time" + update_time + "]";
    }
}