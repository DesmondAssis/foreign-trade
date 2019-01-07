package com.desmond.foreigntrade.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author presleyli
 * @date 2019/1/2 6:13 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadResultVO {
    private String fileName; // 图片.jpg
    private String filePath; // aadf-efef-cde-dfe3434fde3.jpg
    private String url; // http://localhost/a.jpg
}
