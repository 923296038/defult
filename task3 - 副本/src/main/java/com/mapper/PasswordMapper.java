package com.mapper;

import com.pojo.Password;

public interface PasswordMapper {
    boolean updatePassword(Password password);

    String getPswd();
}
