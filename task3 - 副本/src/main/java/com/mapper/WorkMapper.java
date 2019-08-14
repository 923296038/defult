package com.mapper;

import com.pojo.Work;

import java.util.List;

public interface WorkMapper {
    boolean deleteByPrimaryKey(Long id);

    int insert(Work record);

    int insertSelective(Work record);

    Work selectByPrimaryKey(Long id);
    List<Work> selectByWorkName(String work_name);
    List<Work> selectAll();
    boolean updateByPrimaryKeySelective(Work record);

    boolean updateByPrimaryKey(Work record);
    boolean upWork(Long id);
    boolean downWork(Long id);
}