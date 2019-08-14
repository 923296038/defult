package com.pojo;

public class Account {
    private long id;
    private String account_name;
    private String role;
    private long update_at;
    private String update_by;

    public Account(){}

    public Account(long id, String account_name, String role, long update_at, String update_by) {
        this.id = id;
        this.account_name = account_name;
        this.role = role;
        this.update_at = update_at;
        this.update_by = update_by;
    }

    public Account(String account_name, String role, long update_at, String update_by) {
        this.account_name = account_name;
        this.role = role;
        this.update_at = update_at;
        this.update_by = update_by;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account_name='" + account_name + '\'' +
                ", role='" + role + '\'' +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}
