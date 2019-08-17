package com.mapper;

import com.pojo.Studio;

import java.util.List;

public interface StudioMapper {
    boolean deleteByPrimaryKey(Long id);

    int insert(Studio record);

    int insertSelective(Studio record);

    Studio selectByPrimaryKey(Long id);

    List<Studio> findByStudioName(String studio_name);
    List<Studio> findByStatus(String status);
    List<Studio> findAll();

    boolean updateByPrimaryKeySelective(Studio record);

    boolean updateByPrimaryKey(Studio record);

    boolean upStudio(Long id);

    boolean downStudio(Long id);
}