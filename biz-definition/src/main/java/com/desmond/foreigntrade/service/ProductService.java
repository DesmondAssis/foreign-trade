package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.entity.Product;
import com.desmond.foreigntrade.vo.ProductVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author presleyli
 * @date 2018/12/30 5:10 PM
 */
public interface ProductService {
    Product getDetail(Integer id);

    int update(Product product);

    int add(Product product);

    List<Product> getByPks(List<Integer> idIds);

    PageInfo<ProductVO> listByCategory(Integer order, Integer hotFlag, String query, Integer pCatId, Integer catId, Integer pageNum, Integer pageSize);
}
