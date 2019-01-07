package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.entity.Category;
import com.desmond.foreigntrade.entity.User;
import com.desmond.foreigntrade.vo.CategoryVO;

import java.util.List;

/**
 * @author presleyli
 * @date 2018/12/30 5:10 PM
 */
public interface CategoryService {
    Category findByPk(Integer catId);

    /**
     * 根据parentId查询子categories.
     * @param catId
     * @return
     */
    List<Category> findChidlren(Integer catId);

    /**
     * 查询所有categories, 按层次组织.
     * @return
     */
    List<CategoryVO> findAllWithLevel();

    /**
     * 获取行业名.
     * 父级 / 子级
     * @param catId
     * @return
     */
    String getCatName(Integer catId);

    /**
     * 获取所有的二级行业名.
     * @return
     */
    public List<CategoryVO> getAllLv2();
}
