package com.desmond.foreigntrade.dao;

import com.desmond.foreigntrade.entity.Inquire;
import com.desmond.foreigntrade.entity.InquireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquireMapper {
    long countByExample(InquireExample example);

    int deleteByExample(InquireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Inquire record);

    int insertSelective(Inquire record);

    List<Inquire> selectByExample(InquireExample example);

    Inquire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Inquire record, @Param("example") InquireExample example);

    int updateByExample(@Param("record") Inquire record, @Param("example") InquireExample example);

    int updateByPrimaryKeySelective(Inquire record);

    int updateByPrimaryKey(Inquire record);
}