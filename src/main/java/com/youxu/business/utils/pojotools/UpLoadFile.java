package com.youxu.business.utils.pojotools;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpLoadFile {
    private MultipartFile multipartFile;

    private String multipartFileName;
}
