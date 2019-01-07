package com.desmond.foreigntrade.dao.ext;

import com.desmond.foreigntrade.entity.Product;
import com.desmond.foreigntrade.entity.ProductExample;
import com.desmond.foreigntrade.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductExtMapper {

    List<ProductVO> search(@Param("order") Integer order, @Param("hotFlag") Integer hotFlag, @Param("query") String query, @Param("catList") List<Integer> catList);
}