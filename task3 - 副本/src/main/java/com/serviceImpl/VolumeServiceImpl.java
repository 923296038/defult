package com.serviceImpl;

import com.mapper.VolumeMapper;
import com.pojo.Volume;
import com.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service(value = "volumeService")
public class VolumeServiceImpl implements VolumeService {
    @Autowired
    VolumeMapper volumeMapper;
    @Override
    public int insertVolume(Volume volume) {
        volumeMapper.insertVolume(volume);
        return volumeMapper.getId(volume.getVolume_name());
    }

    @Override
    public boolean deleteVolume(Long id) {
        return volumeMapper.deleteVolume(id);
    }

    @Override
    public boolean updateVolume(Volume volume) {
        return volumeMapper.updateVolume(volume);
    }

    @Override
    public List<Volume> findByName(String volume_name) {
        return volumeMapper.findByName(volume_name);
    }

    @Override
    public List<Volume> findAll() {
        return volumeMapper.findAll();
    }

    @Override
    public List<Volume> findByStatus(String status) {
        return volumeMapper.findByStatus(status);
    }

    @Override
    public Volume findById(Long id) {
        return volumeMapper.findById(id);
    }

    @Override
    public boolean upVolume(Long id) {
        return volumeMapper.upVolume(id);
    }

    @Override
    public boolean downVolume(Long id) {
        return volumeMapper.downVolume(id);
    }
}
