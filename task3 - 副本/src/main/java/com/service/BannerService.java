package com.service;

import com.pojo.Banner;
import java.util.List;

public interface BannerService {
    int insertBanner(Banner banner);
    boolean deleteBanner(long id);
    boolean updateBanner(Banner banner);
    List<Banner> findByName(String create_by);
    List<Banner> findAllBanner();
    List<Banner> findByStatus(String status);
    Banner findById(Long id);
    boolean upBanner(long id);
    boolean downBanner(long id);
}
