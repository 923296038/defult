package com.serviceImpl;

import com.mapper.ModuleMapper;
import com.pojo.Module;
import com.service.ModuleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "moduleService")
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    ModuleMapper moduleMapper;
    @Override
    public int insertModule(Module module) {
        moduleMapper.insertModule(module);
        return moduleMapper.getId(module.getModule_name());
    }

    @Override
    public boolean deleteModule(Long id) {
        return moduleMapper.deleteModule(id);
    }

    @Override
    public boolean updateModule(Module module) {
        return moduleMapper.updateModule(module);
    }

    @Override
    public List<Module> findByModuleName(String module_name) {
        return moduleMapper.findByModuleName(module_name);
    }

    @Override
    public List<Module> findAll() {
        return moduleMapper.findAll();
    }

    @Override
    public Module findById(Long id) {
        return moduleMapper.findById(id);
    }
}
