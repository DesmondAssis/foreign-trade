package com.desmond.foreigntrade.controller;

import com.desmond.foreigntrade.config.SConfig;
import com.desmond.foreigntrade.dto.ProductDTO;
import com.desmond.foreigntrade.entity.Category;
import com.desmond.foreigntrade.entity.Product;
import com.desmond.foreigntrade.service.CategoryService;
import com.desmond.foreigntrade.service.FileService;
import com.desmond.foreigntrade.service.ProductService;
import com.desmond.foreigntrade.service.UserService;
import com.desmond.foreigntrade.util.FileUtil;
import com.desmond.foreigntrade.vo.CategoryVO;
import com.desmond.foreigntrade.vo.ProductVO;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author presleyli
 * @date 2018/12/30 9:26 PM
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {
    private final UserService userService;

    private final CategoryService categoryService;
    private final ProductService productService;

    private final FileService fileService;
    private final SConfig sConfig;

    @GetMapping("/products.html")
    public String list(Model model,
                        String query,
                        Integer hotFlag,
                        @RequestParam(required = false) Integer catId,
                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        PageInfo<ProductVO> list = productService.listByCategory(2, hotFlag, query, null, catId, pageNum, pageSize);

        model.addAttribute("page", list);
        model.addAttribute("catId", catId == null ? 0 : catId);
        model.addAttribute("query", query);
        model.addAttribute("hotFlag", hotFlag == null ? -1 : hotFlag);

        List<CategoryVO> allLv2s = categoryService.getAllLv2();

        model.addAttribute("cats", allLv2s);

        return "product_list";
    }

    @GetMapping("/product.html")
    public String detail(Model model, @RequestParam(required = false, defaultValue = "0") Integer id) {
        Product product = productService.getDetail(id);

        if(product != null) {
            ProductDTO dto = new ProductDTO();
            BeanUtils.copyProperties(product, dto);

            dto.setImgUrl(fileService.getFileUrl(dto.getImgPath()));
            dto.setImgMidUrl(fileService.getFileUrl(dto.getImgPathMid()));
            dto.setImgBigUrl(fileService.getFileUrl(dto.getImgPathBig()));

            model.addAttribute("prod", dto);
        } else {
            product = new Product();
            product.setCategoryId(0);
            product.setHotFlag(false);

            model.addAttribute("prod", product);
        }

        List<CategoryVO> allLv2s = categoryService.getAllLv2();

        model.addAttribute("cats", allLv2s);
        model.addAttribute("contextPath", sConfig.getPlatformDomain());

        return "product_detail";
    }

    @PostMapping("/product.html")
    public String addOrUpdate(Product product) {

        if(product.getId() != null && product.getId() > 0) {
            productService.update(product);
        } else {
            productService.add(product);
        }

        return "redirect:products.html";
    }
}
