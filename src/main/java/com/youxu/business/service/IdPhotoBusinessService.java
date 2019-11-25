package com.youxu.business.service;

import com.youxu.business.pojo.IdPhotoBusiness;
import com.youxu.business.pojo.idphotonewadd.GetSpecs;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IdPhotoBusinessService {
    IdPhotoBusiness makeIdPhoto(IdPhotoBusiness idPhotoBusiness) throws Exception;

    GetSpecs getSpecs(String specId) throws Exception;
}
