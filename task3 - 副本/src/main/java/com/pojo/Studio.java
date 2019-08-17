package com.pojo;

import org.hibernate.validator.constraints.NotBlank;

public class Studio {
    private Long id;
    @NotBlank
    private String studio_name;

    private String status;

    private Long create_at;

    private Long update_at;

    private String update_by;

    private String body;

    private String picture;

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", studio_name='" + studio_name + '\'' +
                ", status='" + status + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                ", body='" + body + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudio_name() {
        return studio_name;
    }

    public void setStudio_name(String studio_name) {
        this.studio_name = studio_name;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Studio(Long id, String studio_name, String status, Long create_at, Long update_at, String update_by, String body, String picture) {
        this.id = id;
        this.studio_name = studio_name;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.update_by = update_by;
        this.body = body;
        this.picture = picture;
    }

    public Studio() {
    }
}