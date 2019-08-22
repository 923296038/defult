package com.service;

import com.pojo.Work;

import java.util.List;

public interface WorkService {
    boolean deleteByPrimaryKey(Long id);
    int insert(Work record);
    List<Work> selectByWorkName(String work_name);
    List<Work> selectAll();
    List<Work> selectByVolumeName(String volume_name);
    boolean updateByPrimaryKey(Work record);
    boolean upWork(Long id);
    boolean downWork(Long id);
}
