package com.serviceImpl;

import com.mapper.TypeMapper;
import com.pojo.Type;
import com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return typeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Type record) {
        return typeMapper.insert(record);
    }

    @Override
    public List<Type> findByTypeName(String type_name) {
        return typeMapper.findByTypeName(type_name);
    }

    @Override
    public List<Type> findByVolumeName(String volume_name) {
        return typeMapper.findByVolumeName(volume_name);
    }

    @Override
    public List<Type> findAll() {
        return typeMapper.findAll();
    }

    @Override
    public Type findById(Long id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKey(Type record) {
        return typeMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean upType(Long id) {
        return typeMapper.upType(id);
    }

    @Override
    public boolean downType(Long id) {
        return typeMapper.downType(id);
    }
}
