package com.mapper;

import com.pojo.Volume;

import java.util.Collection;
import java.util.List;

public interface VolumeMapper {
    int insertVolume(Volume volume);
    int getId(String volume_name);
    boolean deleteVolume(Long id);
    boolean updateVolume(Volume volume);
    List<Volume> findByName(String volume_name);
    List<Volume> findAll();
    List<Volume> findByStatus(String status);
    Volume findById(Long id);
    boolean upVolume(Long id);
    boolean downVolume(Long id);
}
