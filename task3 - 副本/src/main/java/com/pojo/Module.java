package com.pojo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class Module {
    private long id;
    @NotBlank(message = "模块名为空")
    private String module_name;
    @NotNull(message = "父节点为空")
    private long parent_node_id;
    private String url;
    private long create_at;
    private String create_by;

    public Module() {
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", module_name='" + module_name + '\'' +
                ", parent_node_id=" + parent_node_id +
                ", url='" + url + '\'' +
                ", create_at=" + create_at +
                ", create_by='" + create_by + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public long getParent_node_id() {
        return parent_node_id;
    }

    public void setParent_node_id(long parent_node_id) {
        this.parent_node_id = parent_node_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Module(String module_name, long parent_node_id, String url, long create_at, String create_by) {
        this.module_name = module_name;
        this.parent_node_id = parent_node_id;
        this.url = url;
        this.create_at = create_at;
        this.create_by = create_by;
    }
}
