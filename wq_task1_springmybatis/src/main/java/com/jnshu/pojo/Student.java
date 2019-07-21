package com.jnshu.pojo;

public class Student {
    private int id;
    private String name;
    private String major;
    private long admission_time;
    private String graduate_school;
    private long online_id;
    private String diary_link;
    private String wish;
    private String guide;
    private long create_time;
    private long update_time;

    public Student() {
    }

    public Student(String name, String major, long admission_time, String graduate_school, long online_id, String diary_link, String wish, String guide,long create_time,long update_time) {
        this.name = name;
        this.major = major;
        this.admission_time = admission_time;
        this.graduate_school = graduate_school;
        this.online_id = online_id;
        this.diary_link = diary_link;
        this.wish = wish;
        this.guide = guide;
        this.create_time = create_time;
        this.update_time=update_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public long getAdmission_time() {
        return admission_time;
    }

    public void setAdmission_time(long admission_time) {
        this.admission_time = admission_time;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public long getOnline_id() {
        return online_id;
    }

    public void setOnline_id(int online_id) {
        this.online_id = online_id;
    }

    public String getDiary_link() {
        return diary_link;
    }

    public void setDiary_link(String diary_link) {
        this.diary_link = diary_link;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", admission_time='" + admission_time + '\'' +
                ", graduate_school='" + graduate_school + '\'' +
                ", online_id=" + online_id +
                ", diary_link='" + diary_link + '\'' +
                ", wish='" + wish + '\'' +
                ", guide='" + guide + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}