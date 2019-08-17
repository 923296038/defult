package com.pojo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Account {
    private long id;
    @NotBlank(message = "账户名为空")
    private String account_name;
    @NotBlank(message = "角色为空")
    private String role;
    private long update_at;
    private String update_by;
    @Size(min=7,max=20,message = "长度大于6")
    private String password;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account_name='" + account_name + '\'' +
                ", role='" + role + '\'' +
                ", update_at=" + update_at +
                ", update_by='" + update_by + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(long id, String account_name, String role, long update_at, String update_by, String password) {
        this.id = id;
        this.account_name = account_name;
        this.role = role;
        this.update_at = update_at;
        this.update_by = update_by;
        this.password = password;
    }

    public Account(){}


}
