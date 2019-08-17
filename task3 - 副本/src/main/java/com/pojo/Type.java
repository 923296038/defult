package com.pojo;

public class Type {
    private Long id;

    private String type_name;

    private String volume_name;

    private String status;

    private Long create_at;

    private Long update_at;

    private String update_by;

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", volume_name='" + volume_name + '\'' +
                ", status='" + status + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
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

    public Type(Long id, String type_name, String volume_name, String status, Long create_at, Long update_at, String update_by) {
        this.id = id;
        this.type_name = type_name;
        this.volume_name = volume_name;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.update_by = update_by;
    }

    public Type() {
    }
}