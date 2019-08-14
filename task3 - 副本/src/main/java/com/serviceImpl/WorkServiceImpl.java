package com.serviceImpl;

import com.mapper.WorkMapper;
import com.pojo.Work;
import com.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service(value = "workService")
public class WorkServiceImpl implements WorkService {
    @Autowired
    WorkMapper workMapper;
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return workMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Work record) {
        return workMapper.insert(record);
    }


    @Override
    public List<Work> selectByWorkName(String work_name) {
        return workMapper.selectByWorkName(work_name);
    }

    @Override
    public List<Work> selectAll() {
        return workMapper.selectAll();
    }

    @Override
    public boolean updateByPrimaryKey(Work record) {
        return workMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean upWork(Long id) {
        return workMapper.upWork(id);
    }

    @Override
    public boolean downWork(Long id) {
        return workMapper.downWork(id);
    }
}
