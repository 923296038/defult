package com.service;

import com.pojo.Type;

import java.util.List;

public interface TypeService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Type record);

    List<Type> findByTypeName(String type_name);

    List<Type> findAll();

    boolean updateByPrimaryKey(Type record);

    boolean upType(Long id);

    boolean downType(Long id);
}
