package com.youxu.business.service.impl;

import com.youxu.business.dao.BannerMapper;
import com.youxu.business.pojo.Banner;
import com.youxu.business.service.BannerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<Banner> selectBannerList() {
        return bannerMapper.selectBannerList();
    }

    @Override
    public Banner selectBannerById(String id) {
        return bannerMapper.selectBannerById(id);
    }
}
