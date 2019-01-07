package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.vo.FileUploadResultVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author presleyli
 * @date 2019/1/2 6:19 PM
 */
public interface FileService {
    FileUploadResultVO upload(MultipartFile f) throws IOException;
    String getFileUrl(String fileKey);
}
