package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.config.SConfig;
import com.desmond.foreigntrade.dao.ProductMapper;
import com.desmond.foreigntrade.dao.ext.ProductExtMapper;
import com.desmond.foreigntrade.entity.Category;
import com.desmond.foreigntrade.entity.Product;
import com.desmond.foreigntrade.entity.ProductExample;
import com.desmond.foreigntrade.vo.ProductVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author presleyli
 * @date 2018/12/30 5:10 PM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ProductExtMapper productExtMapper;

    private final SConfig sConfig;

    private final CategoryService categoryService;

    public List<Product> getByPks(List<Integer> idIds) {
        if(CollectionUtils.isEmpty(idIds)) {
            return null;
        }

        ProductExample productExample = new ProductExample();
        productExample.createCriteria()
                .andIdIn(idIds);

        return productMapper.selectByExample(productExample);
    }

    public int add(Product product) {
        return productMapper.insertSelective(product);
    }

    public int update(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }

    public Product getDetail(Integer id) {
        Product product = productMapper.selectByPrimaryKey(id);

        if(product == null) {
            return null;
        }

        return product;
    }

    public PageInfo<ProductVO> listByCategory(Integer order, Integer hotFlag, String query, Integer pCatId, Integer catId, Integer pageNum, Integer pageSize) {

        List<Integer> catList = new ArrayList<>();
        if(pCatId != null && pCatId > 0) {
            catList.add(pCatId);
        }
        if(catId != null && catId > 0) {
            List<Category> categorys = categoryService.findChidlren(catId);
            if(categorys != null && categorys.size() > 0) {
                catList.addAll(categorys.stream().map(Category::getId).collect(Collectors.toList()));
            }

            catList.add(catId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<ProductVO> allList = productExtMapper.search(order, hotFlag, query, catList);

        allList.stream()
                .forEach(o -> {
                    o.setCategoryName(categoryService.getCatName(o.getCategoryId()));
                    o.setUrl(sConfig.getFileDomain() + o.getImgPath());
                });

        return new PageInfo<>(allList);
    }
}
