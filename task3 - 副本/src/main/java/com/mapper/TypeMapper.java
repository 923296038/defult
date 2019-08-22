package com.mapper;

import com.pojo.Type;

import java.util.List;

public interface TypeMapper {
    boolean deleteByPrimaryKey(Long id);

    int insert(Type record);
    int getId(String type_name);
    int insertSelective(Type record);

    Type selectByPrimaryKey(Long id);

    List<Type> findByTypeName(String type_name);
    List<Type> findByVolumeName(String volume_name);
    List<Type> findAll();

    boolean updateByPrimaryKeySelective(Type record);

    boolean updateByPrimaryKey(Type record);

    boolean upType(Long id);

    boolean downType(Long id);
}