package com.youxu.business.service;

import com.youxu.business.pojo.AccessToken;

import java.util.Date;

public interface AccessTokenService {
    AccessToken selectAccessToken();

    int updateToken(String accessToken);
}
