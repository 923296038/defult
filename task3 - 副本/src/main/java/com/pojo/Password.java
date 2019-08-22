package com.pojo;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class Password {
    private String previous_pswd;
    @NotBlank
    @Size(min=7,max=20,message = "长度大于6")
    private String new_pswd;
    @NotBlank
    @Size(min=7,max=20,message = "长度大于6")
    private String repeat_pswd;

    @Override
    public String toString() {
        return "Password{" +
                "previous_pswd='" + previous_pswd + '\'' +
                ", new_pswd='" + new_pswd + '\'' +
                ", repeat_pswd='" + repeat_pswd + '\'' +
                '}';
    }

    public String getPrevious_pswd() {
        return previous_pswd;
    }

    public void setPrevious_pswd(String previous_pswd) {
        this.previous_pswd = previous_pswd;
    }

    public String getNew_pswd() {
        return new_pswd;
    }

    public void setNew_pswd(String new_pswd) {
        this.new_pswd = new_pswd;
    }

    public String getRepeat_pswd() {
        return repeat_pswd;
    }

    public void setRepeat_pswd(String repeat_pswd) {
        this.repeat_pswd = repeat_pswd;
    }

    public Password(String previous_pswd, String new_pswd, String repeat_pswd) {
        this.previous_pswd = previous_pswd;
        this.new_pswd = new_pswd;
        this.repeat_pswd = repeat_pswd;
    }

    public Password() {
    }
}
