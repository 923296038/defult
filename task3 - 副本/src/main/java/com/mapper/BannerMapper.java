package com.mapper;

import com.pojo.Banner;
import java.util.List;

public interface BannerMapper {
    int insertBanner(Banner banner);
    boolean deleteBanner(long id);
    boolean updateBanner(Banner banner);
    List<Banner> findByName(String create_by);
    List<Banner> findAllBanner();
    boolean upBanner(long id);
    boolean downBanner(long id);
}
