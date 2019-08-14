package com.mapper;

import com.pojo.Module;
import com.pojo.Role;

import java.util.List;

public interface RoleMapper {
    boolean deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> findByRole(String role);

    List<Role> findAll();

    boolean updateByPrimaryKeySelective(Role record);

    boolean updateByPrimaryKey(Role record);
}