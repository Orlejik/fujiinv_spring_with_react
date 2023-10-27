package com.demo.fijinv.Configurations;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface MultipartResolver {
    boolean isMultipart(HttpServletRequest request);
    MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException;
    void cleanupMultipart(MultipartHttpServletRequest request);
}
