package com.youxu.business.service;

import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.pojo.idphotonewadd.CutChangeClothes;
import com.youxu.business.pojo.idphotonewadd.CutChangeClothesResult;
import com.youxu.business.pojo.idphotonewadd.GetSpecs;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;

public interface IdPhotoBusinessService {
    IdPhotoBusiness makeIdPhoto(IdPhotoBusiness idPhotoBusiness) throws Exception;

    GetSpecs getSpecs(String specId) throws Exception;

    IdPhotoBusiness udpateBackGroundColor(IdPhotoBusiness idPhotoBusiness) throws Exception;

    String getIdPhotoWaterMarkByFileName(String fileName, HttpServletResponse response) throws IOException;

    CutChangeClothesResult cutChangeClothes(CutChangeClothes cutChangeClothes);
}
