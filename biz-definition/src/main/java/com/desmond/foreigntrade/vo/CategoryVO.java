package com.desmond.foreigntrade.vo;

import com.desmond.foreigntrade.entity.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author presleyli
 * @date 2018/12/31 10:28 AM
 */
@Data
public class CategoryVO {
    private Integer id;
    private Integer parentId;
    private String name;
    private Integer level;

    public CategoryVO(Category category) {
        BeanUtils.copyProperties(category, this);
    }

    private List<CategoryVO> subList = new ArrayList<>();
}
