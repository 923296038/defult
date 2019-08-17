package com.pojo;

import org.hibernate.validator.constraints.NotBlank;

import java.security.SecureRandom;

public class Message {
    private long id;
    @NotBlank(message = "作品标题不为空")
    private String work_title;
    private String user_name;
    private String status;
    private long create_at;
    private long update_at;
    private String update_by;
    private String content;
    private String reply;

    public Message(long id, String work_title, String user_name, String status, long create_at, long update_at, String update_by, String content, String reply) {
        this.id = id;
        this.work_title = work_title;
        this.user_name = user_name;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.update_by = update_by;
        this.content = content;
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", work_title='" + work_title + '\'' +
                ", user_name='" + user_name + '\'' +
                ", status='" + status + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                ", content='" + content + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWork_title() {
        return work_title;
    }

    public void setWork_title(String work_title) {
        this.work_title = work_title;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
