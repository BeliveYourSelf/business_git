package com.youxu.business.service;

import com.youxu.business.pojo.Share;

import java.text.ParseException;

public interface ShareService {
    Integer insertShare(Share share) throws ParseException;
}
