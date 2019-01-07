package com.desmond.foreigntrade.dao;

import com.desmond.foreigntrade.entity.InquireProduct;
import com.desmond.foreigntrade.entity.InquireProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquireProductMapper {
    long countByExample(InquireProductExample example);

    int deleteByExample(InquireProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InquireProduct record);

    int insertSelective(InquireProduct record);

    List<InquireProduct> selectByExample(InquireProductExample example);

    InquireProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InquireProduct record, @Param("example") InquireProductExample example);

    int updateByExample(@Param("record") InquireProduct record, @Param("example") InquireProductExample example);

    int updateByPrimaryKeySelective(InquireProduct record);

    int updateByPrimaryKey(InquireProduct record);
}