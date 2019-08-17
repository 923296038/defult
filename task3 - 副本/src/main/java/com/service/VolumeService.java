package com.service;

import com.pojo.Volume;

import java.util.Collection;
import java.util.List;

public interface VolumeService {
    int insertVolume(Volume volume);
    boolean deleteVolume(Long id);
    boolean updateVolume(Volume volume);
    List<Volume> findByName(String volume_name);
    List<Volume> findAll();
    List<Volume> findByStatus(String status);
    Volume findById(Long id);
    boolean upVolume(Long id);
    boolean downVolume(Long id);
}
