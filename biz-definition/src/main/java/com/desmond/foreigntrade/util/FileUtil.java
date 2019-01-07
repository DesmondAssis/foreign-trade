package com.desmond.foreigntrade.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

@Slf4j
public class FileUtil {
    private final static String TMP_FOLDER = System.getProperty("java.io.tmpdir");

    private final static String FILE_SEPARATOR = System.getProperty("file.separator");

    private final static String FILE_DOT = ".";


    public static void main(String[] args) throws Exception {
        System.out.println(getSuffix("a.jpg"));
    }

    public static String getSuffix(String filename) {
        if(StringUtils.isBlank(filename)) {
            return "";
        }

        int idx = filename.lastIndexOf(FILE_DOT);

        if(idx == -1) {
            return "";
        }

        filename = filename.substring(idx);

        return filename;
    }

    /**
     * 根据文件字节数组，生成到磁盘文件.
     * @param bytes 文件字节数组
     * @param file 磁盘文件
     */
    public static boolean generateFile(byte[] bytes, File file) {
        boolean isStoreSuccess = false;
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();

            isStoreSuccess = true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return isStoreSuccess;
    }

    public static File getFile(String parentPath, String fileName) {
        return new File(parentPath, fileName);
    }

}
