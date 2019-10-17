package com.youxu.business.service.impl;

import com.youxu.business.dao.AccessTokenMapper;
import com.youxu.business.dao.OrderMapper;
import com.youxu.business.dao.ShareMapper;
import com.youxu.business.pojo.AccessToken;
import com.youxu.business.pojo.Document;
import com.youxu.business.pojo.Folder;
import com.youxu.business.pojo.Share;
import com.youxu.business.service.AccessTokenService;
import com.youxu.business.service.ShareService;
import com.youxu.business.utils.transicatetool.DateTransform;
import com.youxu.business.utils.uuid.TimeProblem;
import com.youxu.business.utils.uuid.UUIDUtils;
import com.youxu.business.utils.wechat.qrcode.MiniAppCode;
import com.youxu.business.utils.wechat.requestapitool.RequestApiTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    private final static Logger logger = LoggerFactory.getLogger(ShareServiceImpl.class);

    @Resource
    private ShareMapper shareMapper;
    @Resource
    private AccessTokenMapper accessTokenMapper;
    @Resource
    private AccessTokenService accessTokenService;
    @Resource
    private RequestApiTool requestApiTool;
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Share insertShare(Share share) throws ParseException {
        //更新accessToken
        String userId = share.getShareUserId().toString();
        String shareCode = UUIDUtils.generateShortUuid();
        String fakerOne = UUIDUtils.generateShortUuid();
        String fakerTwo = UUIDUtils.generateShortUuid();
        String userIdAndInvitationCode = userId + "#" + shareCode;
        share.setExtactionCode(shareCode);
        String qrCodePath = updateAccessTokenAndCreateQRcode(userIdAndInvitationCode);
        share.setQrCode(qrCodePath);
        // 添加b/s分享路径
        String browserUrl = share.getBrowserUrl();
        if (org.apache.commons.lang.StringUtils.isNotEmpty(browserUrl)) {
            share.setBrowserUrl(browserUrl + "?userId=" + userId + "&" + "shareCode=" + fakerOne + shareCode + fakerTwo);
        }
        // 抽取文件夹中的文件
        Folder folder = share.getFolder();
        List<Document> document = new ArrayList<>();
        List<Document> documentInFolder = getDocumentInFolder(folder, document);
        List<String> documentConsult = new ArrayList<>();
        for(Document documentNew:documentInFolder){
            String documentUrl = documentNew.getDocumentUrl();
            documentConsult.add(documentUrl);
        }
        String documentConsultString = documentConsult.toString();
        share.setShareContentUrl(documentConsultString);
        shareMapper.insertShare(share);
        int shareId = orderMapper.lastInsertId();
        Share shareNew = shareMapper.selectShareById(shareId);
        return shareNew;
    }

    /**
     * 获取文件中所有文件
     * @param folder
     * @return
     */
    private List<Document> getDocumentInFolder(Folder folder, List<Document> document) {
        List<Document> documentList = folder.getDocumentList();
        if (documentList.size() > 0) {
            document.addAll(documentList);
        }
        List<Folder> folderList = folder.getFolderList();
        if(!StringUtils.isEmpty(folderList) && folderList.size() > 0) {
            for (Folder folderNew : folderList) {
                getDocumentInFolder(folderNew, document);
            }
        }
        return document;
    }

    @Override
    public Share selectShareByUserIdAndExtactionCode(Share share) {
        Share shareNew = shareMapper.selectShareByUserIdAndExtactionCode(share);
        return shareNew;
    }

    @Override
    public Share selectShareById(String id) {
        Share share = shareMapper.selectShareById(Integer.valueOf(id));
        return share;
    }

    @Override
    public Share downloadShare(Share share) {
        Share shareNew = shareMapper.downloadShare(share);
        return shareNew;
    }


    /**
     * 生成二维码
     *
     * @param userIdAndInvitationCode
     * @return
     * @throws ParseException
     */
    public String updateAccessTokenAndCreateQRcode(String userIdAndInvitationCode) throws ParseException {
        AccessToken accessToken = accessTokenMapper.selectAccessToken();
        String modifyTimeString = accessToken.getModifyTimeString();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dataBaseTime = sdf1.parse(modifyTimeString);
        Date nowDate = new Date();
        logger.info("原始时间" + nowDate);
        TimeProblem timeProblem = new TimeProblem();
        Date date = timeProblem.addEightHour(nowDate);
        logger.info("加八小时" + date);
        long diff = date.getTime() - dataBaseTime.getTime();//毫秒1728000（8小时）
        // 计算差多少分钟
        long min = diff / 1000 / 60;
        logger.info("时间差大于是否60分钟---------------------" + min + "现在时间：" + date.getTime() + "数据库accessToken更新时间:" + dataBaseTime.getTime());
        if (min >= 60) {
            AccessToken accessTokenMethod = requestApiTool.getAccessTokenMethod();//微信平台获得accesstoken和更新状况
            int i = accessTokenService.updateToken(accessTokenMethod.getAccessToken());//超过两小时更新accessToken
            String accessTokenNew = accessTokenMethod.getAccessToken();
            accessToken.setAccessToken(accessTokenNew);
        }
        String token = accessToken.getAccessToken();
        MiniAppCode miniAppCode = new MiniAppCode();
        StringBuilder stringBuilderPath = miniAppCode.getminiqrQr(userIdAndInvitationCode, token);//上传图片路径
        String stringPath = stringBuilderPath.toString();
        return stringPath;
    }


}
