package com.service;

import com.pojo.Role;

import java.util.List;

public interface RoleService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Role record);

    List<Role> findByRole(String role);

    List<Role> findAll();

    boolean updateByPrimaryKey(Role record);

}
