package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.config.BaseConfig;
import com.desmond.foreigntrade.config.SConfig;
import com.desmond.foreigntrade.util.FileUtil;
import com.desmond.foreigntrade.vo.FileUploadResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author presleyli
 * @date 2019/1/2 6:19 PM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final BaseConfig baseConfig;
    private final SConfig sConfig;

    public FileUploadResultVO upload(MultipartFile f) throws IOException {
        byte[] bytes = f.getBytes();

        String filename = f.getOriginalFilename();
        String fileKey = UUID.randomUUID().toString();

        String suffix = FileUtil.getSuffix(filename);

        fileKey += suffix;

        File file = FileUtil.getFile(baseConfig.getFilePath(), fileKey);
        file.createNewFile();
        boolean b = file.setReadable(true, false);

        FileUtil.generateFile(bytes, file);

        FileUploadResultVO resultVO = new FileUploadResultVO(filename, fileKey, getFileUrl(fileKey));

        return resultVO;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

    public String getFileUrl(String fileKey) {
        return sConfig.getFileDomain() + fileKey;
    }
}
