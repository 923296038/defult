package com.pojo;

public class Work {
    private Long id;

    private String work_name;

    private String volume_name;

    private String second_volume_name;

    private String status;

    private Long create_at;

    private Long update_at;

    private String update_by;

    private String introduction;
    private String pic;
    private String video;
    private String pic1;
    private String article;

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", work_name='" + work_name + '\'' +
                ", volume_name='" + volume_name + '\'' +
                ", second_volume_name='" + second_volume_name + '\'' +
                ", status='" + status + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                ", introduction='" + introduction + '\'' +
                ", pic='" + pic + '\'' +
                ", video='" + video + '\'' +
                ", pic1='" + pic1 + '\'' +
                ", article='" + article + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWork_name() {
        return work_name;
    }

    public void setWork_name(String work_name) {
        this.work_name = work_name;
    }

    public String getVolume_name() {
        return volume_name;
    }

    public void setVolume_name(String volume_name) {
        this.volume_name = volume_name;
    }

    public String getSecond_volume_name() {
        return second_volume_name;
    }

    public void setSecond_volume_name(String second_volume_name) {
        this.second_volume_name = second_volume_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Work(Long id, String work_name, String volume_name, String second_volume_name, String status, Long create_at, Long update_at, String update_by, String introduction, String pic, String video, String pic1, String article) {
        this.id = id;
        this.work_name = work_name;
        this.volume_name = volume_name;
        this.second_volume_name = second_volume_name;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.update_by = update_by;
        this.introduction = introduction;
        this.pic = pic;
        this.video = video;
        this.pic1 = pic1;
        this.article = article;
    }

    public Work() {
    }
}