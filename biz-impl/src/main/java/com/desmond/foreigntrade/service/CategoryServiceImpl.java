package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.dao.CategoryMapper;
import com.desmond.foreigntrade.entity.Category;
import com.desmond.foreigntrade.entity.CategoryExample;
import com.desmond.foreigntrade.entity.User;
import com.desmond.foreigntrade.vo.CategoryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author presleyli
 * @date 2018/12/30 5:10 PM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;

    @Override
    public Category findByPk(Integer catId) {
        return categoryMapper.selectByPrimaryKey(catId);
    }

    /**
     * 根据parentId查询子categories.
     * @param catId
     * @return
     */
    public List<Category> findChidlren(Integer catId) {
        CategoryExample ex = new CategoryExample();
        ex.createCriteria()
                .andParentIdEqualTo(catId)
                .andDelFlagEqualTo(0);

        return categoryMapper.selectByExample(ex);
    }

    public String getCatName(Integer catId) {
        Category category = categoryMapper.selectByPrimaryKey(catId);

        if(category == null) {
            return "";
        }

        if(category.getLevel() == 1) {
            return category.getName();
        }

        if(category.getLevel() == 2) {
            Category p = categoryMapper.selectByPrimaryKey(category.getParentId());

            return p.getName() + " / " + category.getName();
        }

        return "";
    }

    /**
     * 获取所有的二级行业名.
     * @return
     */
    public List<CategoryVO> getAllLv2() {
        CategoryExample ex = new CategoryExample();
        ex.createCriteria()
                .andLevelEqualTo(2)
                .andDelFlagEqualTo(0);

        List<Category> allLv2List = categoryMapper.selectByExample(ex);

        List<CategoryVO> vos = allLv2List.stream()
                .map(CategoryVO::new)
                .peek(o -> o.setName(getCatName(o.getParentId()) + " / " + o.getName()))
                .collect(Collectors.toList());

        return vos;
    }

    /**
     * 查询所有categories, 按层次组织.
     * @return
     */
    public List<CategoryVO> findAllWithLevel() {
        CategoryExample ex = new CategoryExample();
        ex.createCriteria().andDelFlagEqualTo(0);

        List<Category> allList = categoryMapper.selectByExample(ex);

        Map<Integer, CategoryVO> firstMap = new LinkedHashMap<>(3);

        List<CategoryVO> voList = allList.stream()
                .map(CategoryVO::new)
                .collect(Collectors.toList());

        voList.stream()
                .filter(o -> o.getLevel() == 1)
                .forEach(o -> {
                    firstMap.put(o.getId(), o);
                });

        voList.stream()
                .filter(o -> o.getLevel() == 2)
                .forEach(o -> {
                    firstMap.get(o.getParentId()).getSubList().add(o);
                });

        return new ArrayList<>(firstMap.values());
    }
}
