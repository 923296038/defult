package com.serviceImpl;

import com.mapper.BannerMapper;
import com.pojo.Account;
import com.pojo.Banner;
import com.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bannerService")
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public int insertBanner(Banner banner) {
        return bannerMapper.insertBanner(banner);
    }

    @Override
    public boolean deleteBanner(long id) {
        return bannerMapper.deleteBanner(id);
    }

    @Override
    public boolean updateBanner(Banner banner) {
        return bannerMapper.updateBanner(banner);
    }

    @Override
    public List<Banner> findByName(String create_by) {
        return bannerMapper.findByName(create_by);
    }

    @Override
    public List<Banner> findAllBanner() {
        return bannerMapper.findAllBanner();
    }

    @Override
    public List<Banner> findByStatus(String status) {
        return bannerMapper.findByStauts(status);
    }

    @Override
    public Banner findById(Long id) {
        return bannerMapper.findById(id);
    }

    @Override
    public boolean upBanner(long id) {
        return bannerMapper.upBanner(id);
    }

    @Override
    public boolean downBanner(long id) {
        return bannerMapper.downBanner(id);
    }
}
