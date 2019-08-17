package com.mapper;
import com.pojo.Module;

import java.util.List;

public interface ModuleMapper {
    int insertModule(Module module);
    boolean deleteModule(Long id);
    boolean updateModule(Module module);
    Module findById(Long id);
    List<Module> findByModuleName(String module_name);
    List<Module> findAll();

}
