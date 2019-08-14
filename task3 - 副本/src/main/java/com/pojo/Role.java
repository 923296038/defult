package com.pojo;

public class Role {
    private Long id;

    private String role;

    private Long create_at;

    private String create_by;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", create_at=" + create_at +
                ", create_by='" + create_by + '\'' +
                '}';
    }

    public Role(Long id, String role, Long create_at, String create_by) {
        this.id = id;
        this.role = role;
        this.create_at = create_at;
        this.create_by = create_by;
    }

    public Role() {
        super();
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
        this.role = role == null ? null : role.trim();
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
        this.create_by = create_by == null ? null : create_by.trim();
    }
}