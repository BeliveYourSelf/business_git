package com.youxu.business.service;


import com.youxu.business.pojo.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> selectBannerList(String contentType);

    Banner selectBannerById(String id);
}
