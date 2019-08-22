package com.serviceImpl;

import com.mapper.RoleMapper;
import com.pojo.Role;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        roleMapper.insert(record);
        return roleMapper.getId(record.getCreate_at());
    }

    @Override
    public List<Role> findByRole(String role) {
        return roleMapper.findByRole(role);
    }

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public boolean updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }
}
