package com.mybatis.test;

import java.util.List;

public interface IUserOperation {

    public User selectUserByID(int id);

    public List<User> selectUsersByName(String userName);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

}