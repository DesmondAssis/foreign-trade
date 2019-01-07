package com.desmond.foreigntrade.vo;

import com.desmond.foreigntrade.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProductVO extends Product{
    private String categoryName;
    private String url;

    public ProductVO(Product product) {
        BeanUtils.copyProperties(product, this);
    }
}