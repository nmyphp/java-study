package com.free.jquery.uploadify.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

/**
 * @author chenlongjs
 * @date 2018/8/22
 */
@Slf4j
@Controller
@RequestMapping("/test")
public class DefaultController {

    public static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @Value("${upload.path}")
    private String path;

    @RequestMapping(value = "/upload.do", method = {RequestMethod.POST, RequestMethod.GET})
    public String upload(HttpServletRequest request, HttpServletResponse response) {
        try {
            MultipartHttpServletRequest mutiRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> fileMap = mutiRequest.getFileMap();
            MultipartFile uploadFile = null;
            for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
                uploadFile = entity.getValue();
                break;
            }
            File destFile = new File(path + uploadFile.getOriginalFilename());
            if (!destFile.exists()) {
                destFile.createNewFile();
            }
            FileOutputStream outputStream = new FileOutputStream(destFile);
            try {
                IOUtils.copy(request.getInputStream(), outputStream);
            } finally {
                IOUtils.closeQuietly(outputStream);
                IOUtils.closeQuietly(uploadFile.getInputStream());
            }
        } catch (Exception e) {
            logger.error("上传文件时发生异常", e);
        }
        return "done";
    }
}
