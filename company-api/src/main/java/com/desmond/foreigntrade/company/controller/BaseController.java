package com.desmond.foreigntrade.company.controller;

import com.desmond.foreigntrade.config.SConfig;
import com.desmond.foreigntrade.entity.Category;
import com.desmond.foreigntrade.service.CategoryService;
import com.desmond.foreigntrade.service.ProductService;
import com.desmond.foreigntrade.vo.CategoryVO;
import com.desmond.foreigntrade.vo.NavVO;
import com.desmond.foreigntrade.vo.ProductVO;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author presleyli
 * @date 2018/12/30 9:26 PM
 */
@Slf4j
@Component
public class BaseController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private SConfig sConfig;

    @Autowired
    private ProductService productService;

    public void processBasic(Model model) {
        model.addAttribute("contextPath", sConfig.getCompanyDomain());

        this.setNavs(model);
        this.setLeftNavigators(model);
    }

    public void setHotProducts(Model model) {
        PageInfo<ProductVO> list = productService.listByCategory(2, 1, null, 0, 0, 1, 4);
        model.addAttribute("page", list);
        model.addAttribute("dropCheckBox", true);
    }

    public void setNavs(Model model) {
        List<NavVO> navVOS = new ArrayList<>();
        navVOS.add(new NavVO("Home", "index.html"));

        // categories
        navVOS.addAll(getCategories());

        // feedback
        navVOS.addAll(getFeedback());

        model.addAttribute("navs", navVOS);
    }

    public void setLeftNavigators(Model model) {
        List<CategoryVO> categoryVOS = categoryService.findAllWithLevel();

        model.addAttribute("cats", categoryVOS);
    }

    private List<NavVO> getFeedback() {
        List<NavVO> cats = new ArrayList<>();
        String url = request.getRequestURI();

        if(url.endsWith("feedback.html")) {
            cats.add(new NavVO("Feedback", "feedback.html"));
        }

        return cats;
    }

    private List<NavVO> getAboutUs() {
        List<NavVO> cats = new ArrayList<>();
        String url = request.getRequestURI();

        if(url.endsWith("aboutUs.html")) {
            cats.add(new NavVO("About Us", "aboutus.html"));
        }

        return cats;
    }

    private List<NavVO> getCategories() {
        List<NavVO> cats = new ArrayList<>();

        String catId = request.getParameter("catId");
        Integer catIdInt = NumberUtils.toInt(catId);

        if(catIdInt > 0) {
            Category category = categoryService.findByPk(catIdInt);

            if(category != null) {
                if(category.getParentId() != 0) {
                    Category pcategory = categoryService.findByPk(category.getParentId());
                    if(pcategory != null) {
                        cats.add(getCategory(pcategory));
                    }
                }

                cats.add(getCategory(category));
            }
        }

        return cats;
    }

    private NavVO getCategory(Category category) {
        String name = category.getName();
        String link = "product.html?pcatId=" + category.getParentId() + "&catId=" + category.getId();

        return new NavVO(name, link);
    }
}
