package com.service;

import com.pojo.Module;
import java.util.List;

public interface ModuleService {
    int insertModule(Module module);
    boolean deleteModule(Long id);
    boolean updateModule(Module module);
    List<Module> findByModuleName(String module_name);
    List<Module> findAll();
    Module findById(Long id);
}
