package com.youxu.business.service.impl;

import com.youxu.business.dao.AccessTokenMapper;
import com.youxu.business.pojo.AccessToken;
import com.youxu.business.service.AccessTokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    @Resource
    private AccessTokenMapper accessTokenMapper;
    @Override
    public AccessToken selectAccessToken() {
        return accessTokenMapper.selectAccessToken();
    }

    @Override
    public int updateToken(String accessToken) {
        return accessTokenMapper.updateToken(accessToken);
    }
}
