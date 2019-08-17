package com.pojo;

import org.hibernate.validator.constraints.NotBlank;

public class Role {
    private Long id;
    @NotBlank
    private String role;

    private Long create_at;

    private String create_by;
    @NotBlank
    private String permission;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", create_at=" + create_at +
                ", create_by='" + create_by + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Role(Long id, String role, Long create_at, String create_by, String permission) {
        this.id = id;
        this.role = role;
        this.create_at = create_at;
        this.create_by = create_by;
        this.permission = permission;
    }

    public Role() {
    }
}