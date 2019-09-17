package com.youxu.business.service.impl;

import com.youxu.business.dao.ShareMapper;
import com.youxu.business.pojo.AccessToken;
import com.youxu.business.pojo.Share;
import com.youxu.business.service.AccessTokenService;
import com.youxu.business.service.ShareService;
import com.youxu.business.utils.uuid.TimeProblem;
import com.youxu.business.utils.wechat.qrcode.MiniAppCode;
import com.youxu.business.utils.wechat.requestapitool.RequestApiTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ShareServiceImpl implements ShareService {
    private final static Logger logger = LoggerFactory.getLogger(ShareServiceImpl.class);

    @Resource
    private ShareMapper shareMapper;
    @Resource
    private AccessTokenService accessTokenService;
    @Override
    public Integer insertShare(Share share) {
        //更新accessToken
        String shareUserId = share.getShareUserId().toString();
        StringBuffer userId = new StringBuffer(shareUserId);

      /*  userId+","+
        ShareServiceImpl shareService = new ShareServiceImpl();*/
//        shareService.updateAccessTokenAndCreateQRcode();
        return shareMapper.insertShare(share);
    }

    public void updateAccessTokenAndCreateQRcode(String userIdAndInvitationCode) throws ParseException {
        AccessToken accessToken = accessTokenService.selectAccessToken();
        String modifyTimeString = accessToken.getModifyTimeString();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dataBaseTime = sdf1.parse(modifyTimeString);
        Date nowDate = new Date();
        logger.info("原始时间"+nowDate);
        TimeProblem timeProblem = new TimeProblem();
        Date date = timeProblem.addEightHour(nowDate);
        logger.info("加八小时"+date);
        long diff = date.getTime() - dataBaseTime.getTime();//毫秒1728000（8小时）
        // 计算差多少分钟
        long min = diff /1000/60;
        logger.info("时间差大于是否60分钟---------------------"+min+"现在时间："+date.getTime()+"数据库accessToken更新时间:"+dataBaseTime.getTime());
        if (min >=60) {
            RequestApiTool requestApiTool = new RequestApiTool();
            AccessToken accessTokenMethod = requestApiTool.getAccessTokenMethod();//微信平台获得accesstoken和更新状况
            int i = accessTokenService.updateToken(accessTokenMethod.getAccessToken());//超过两小时更新accessToken
            String accessTokenNew = accessTokenMethod.getAccessToken();
            accessToken.setAccessToken(accessTokenNew);
        }
        String token = accessToken.getAccessToken();
        MiniAppCode miniAppCode = new MiniAppCode();
        StringBuilder stringBuilderPath = miniAppCode.getminiqrQr(userIdAndInvitationCode, token);//上传图片路径
        String stringPath = stringBuilderPath.toString();

    }


}
