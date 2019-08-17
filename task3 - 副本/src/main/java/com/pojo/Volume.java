package com.pojo;

public class Volume {
    private long id;
    private String volume_name;
    private String status;
    private long create_at;
    private long update_at;
    private String update_by;

    @Override
    public String toString() {
        return "Volume{" +
                "id=" + id +
                ", volume_name='" + volume_name + '\'' +
                ", status='" + status + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVolume_name() {
        return volume_name;
    }

    public void setVolume_name(String volume_name) {
        this.volume_name = volume_name;
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

    public Volume() {
    }

    public Volume(String volume_name, String status, long create_at, long update_at, String update_by) {
        this.volume_name = volume_name;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.update_by = update_by;
    }
}
