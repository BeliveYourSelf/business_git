package com.youxu.business.service;

import com.youxu.business.pojo.IdPhotoBusiness;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IdPhotoBusinessService {
    IdPhotoBusiness upLoadIdPhoto(IdPhotoBusiness idPhotoBusiness) throws Exception;
}
