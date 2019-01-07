package com.desmond.foreigntrade.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {
    private Integer id;

    private String code;

    private String name;

    private String desc;

    private Integer categoryId;

    private String imgName;

    private String imgPath;

    private String imgPathMid;

    private String imgPathBig;

    private Boolean hotFlag;

    private String imgUrl;
    private String imgMidUrl;
    private String imgBigUrl;
}