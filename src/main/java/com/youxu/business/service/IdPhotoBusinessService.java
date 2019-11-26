package com.youxu.business.service;

import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.pojo.idphotonewadd.GetSpecs;

public interface IdPhotoBusinessService {
    IdPhotoBusiness makeIdPhoto(IdPhotoBusiness idPhotoBusiness) throws Exception;

    GetSpecs getSpecs(String specId) throws Exception;

    IdPhotoBusiness udpateBackGroundColor(IdPhotoBusiness idPhotoBusiness) throws Exception;
}
