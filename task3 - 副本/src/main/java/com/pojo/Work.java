package com.pojo;

public class Work {
    private Long id;

    private String work_name;

    private String collection_name;

    private String second_collection_name;

    private String status;

    private Long create_at;

    private Long update_at;

    private String update_by;

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", work_name='" + work_name + '\'' +
                ", collection_name='" + collection_name + '\'' +
                ", second_collection_name='" + second_collection_name + '\'' +
                ", status='" + status + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                '}';
    }

    public Work(Long id, String work_name, String collection_name, String second_collection_name, String status, Long create_at, Long update_at, String update_by) {
        this.id = id;
        this.work_name = work_name;
        this.collection_name = collection_name;
        this.second_collection_name = second_collection_name;
        this.status = status;
        this.create_at = create_at;
        this.update_at = update_at;
        this.update_by = update_by;
    }

    public Work() {
        super();
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
        this.work_name = work_name == null ? null : work_name.trim();
    }

    public String getCollection_name() {
        return collection_name;
    }

    public void setCollection_name(String collection_name) {
        this.collection_name = collection_name == null ? null : collection_name.trim();
    }

    public String getSecond_collection_name() {
        return second_collection_name;
    }

    public void setSecond_collection_name(String second_collection_name) {
        this.second_collection_name = second_collection_name == null ? null : second_collection_name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        this.update_by = update_by == null ? null : update_by.trim();
    }
}