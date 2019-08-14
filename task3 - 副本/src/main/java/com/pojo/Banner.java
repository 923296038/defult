package com.pojo;

public class Banner {
    private long id;
    private String create_by;
    private String url;
    private String status;
    private long create_at;
    private long update_at;

    public Banner() {
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", update_by='" + create_by + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUpdate_by() {
        return create_by;
    }

    public void setUpdate_by(String update_by) {
        this.create_by = update_by;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Banner(String create_by, String url, String status, long create_at, long update_at) {
        this.create_by = create_by;
        this.url = url;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
    }
}
