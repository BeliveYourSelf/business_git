package com.youxu.business.utils.transicatetool;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

public class InRequestGetMultipartFile {

    public static MultipartFile inRequestGetMultipartFile(HttpServletRequest request){
        String contentType = request.getContentType();
        if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
            MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            MultipartFile file = multipartRequest.getFile("file");
            return file;
        }
        MultipartFile o = null;
        return o;
    }
}
