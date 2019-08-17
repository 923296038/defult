package com.service;

import com.pojo.Studio;

import java.util.List;

public interface StudioService {
    boolean deleteByPrimaryKey(Long id);

    int insert(Studio record);
    Studio selectByPrimaryKey(Long id);
    List<Studio> findByStudioName(String studio_name);
    List<Studio> findByStatus(String status);
    List<Studio> findAll();

    boolean updateByPrimaryKey(Studio record);

    boolean upStudio(Long id);

    boolean downStudio(Long id);
}
