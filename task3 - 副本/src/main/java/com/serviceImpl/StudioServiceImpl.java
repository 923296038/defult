package com.serviceImpl;

import com.mapper.StudioMapper;
import com.pojo.Studio;
import com.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "studioService")
public class StudioServiceImpl implements StudioService {
    @Autowired
    StudioMapper studioMapper;
    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return studioMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Studio record) {
        studioMapper.insert(record);
        return studioMapper.getId(record.getStudio_name());
    }

    @Override
    public Studio selectByPrimaryKey(Long id) {
        return studioMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Studio> findByStudioName(String studio_name) {
        return studioMapper.findByStudioName(studio_name);
    }

    @Override
    public List<Studio> findByStatus(String status) {
        return studioMapper.findByStatus(status);
    }

    @Override
    public List<Studio> findAll() {
        return studioMapper.findAll();
    }

    @Override
    public boolean updateByPrimaryKey(Studio record) {
        return studioMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean upStudio(Long id) {
        return studioMapper.upStudio(id);
    }

    @Override
    public boolean downStudio(Long id) {
        return studioMapper.downStudio(id);
    }
}
