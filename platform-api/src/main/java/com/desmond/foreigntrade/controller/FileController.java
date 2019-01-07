package com.desmond.foreigntrade.controller;

import com.desmond.foreigntrade.service.FileService;
import com.desmond.foreigntrade.util.FileUtil;
import com.desmond.foreigntrade.vo.FileUploadResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author presleyli
 * @date 2019/1/2 6:13 PM
 */
@Slf4j
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    @CrossOrigin
    public FileUploadResultVO upload(@RequestParam("file") MultipartFile f) throws IOException {
        FileUploadResultVO vo = fileService.upload(f);

        return vo;
    }
}
