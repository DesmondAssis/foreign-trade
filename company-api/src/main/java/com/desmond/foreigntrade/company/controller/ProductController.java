package com.desmond.foreigntrade.company.controller;

import com.desmond.foreigntrade.dto.ProductDTO;
import com.desmond.foreigntrade.entity.Category;
import com.desmond.foreigntrade.entity.Product;
import com.desmond.foreigntrade.entity.User;
import com.desmond.foreigntrade.service.CategoryService;
import com.desmond.foreigntrade.service.FileService;
import com.desmond.foreigntrade.service.ProductService;
import com.desmond.foreigntrade.service.UserService;
import com.desmond.foreigntrade.vo.CategoryVO;
import com.desmond.foreigntrade.vo.ProductVO;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author presleyli
 * @date 2018/12/30 9:26 PM
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController extends BaseController {
    private final UserService userService;

    private final CategoryService categoryService;
    private final ProductService productService;
    private final FileService fileService;

    @GetMapping("/product.html")
    public String list(Model model,
                        @RequestParam(required = false, defaultValue = "1") Integer order,
                        @RequestParam(required = false) Integer pcatId,
                        String query,
                        @RequestParam(required = false) Integer catId,
                        @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                        @RequestParam(required = false, defaultValue = "12") Integer pageSize) {
        PageInfo<ProductVO> list = productService.listByCategory(order, -1, query, pcatId, catId, pageNum, pageSize);

        model.addAttribute("page", list);
        model.addAttribute("pcatId", pcatId);
        model.addAttribute("catId", catId);

        setSubCategories(pcatId, model);

        setListHeader(list, model);

        super.processBasic(model);

        return "list";
    }

    private void setListHeader(PageInfo<ProductVO> list, Model model) {
        if(list != null && !CollectionUtils.isEmpty(list.getList())) {
            StringBuilder titleSb = new StringBuilder();
            String cat = "cat";
            for(ProductVO productVO : list.getList()) {
                titleSb.append(productVO.getCode()).append(" ").append(productVO.getName()).append(",");
                cat = productVO.getCategoryName();
            }

            model.addAttribute("title", titleSb);
            model.addAttribute("summary", cat + ":" + titleSb);

        } else {
            model.addAttribute("title", "snorkeling ,diving ,surfing and swimming products");
            model.addAttribute("summary", "PREBOOMING is one of the most professional water sports goods like the snorkeling ,diving ,surfing and swimming products manufacturer in China. We design, produce and sell full face snorkeling masks, snorkeling fins, diving wetsuit, diving mask&fin&snorkel, neoprene gloves, neoprene boots, sup, surfboard leash, rash guard, swimming goggles and swimming caps.\n" +
                    "\n" +
                    "Nowadays, PREBOOMING has customers in USA, Europe, South America, Australia, New Zealand ,Canada,etc. We could do OEM and ODM service for you. Olny you have any requirements,please let us know and feel free to contact us. Thank you.");
        }
    }

    @GetMapping("/product_detail.html")
    public String detail(Model model, @RequestParam Integer id) {
        Product product = productService.getDetail(id);

        ProductDTO dto = new ProductDTO();
        BeanUtils.copyProperties(product, dto);

        dto.setImgUrl(fileService.getFileUrl(dto.getImgPath()));
        dto.setImgMidUrl(fileService.getFileUrl(dto.getImgPathMid()));
        dto.setImgBigUrl(fileService.getFileUrl(dto.getImgPathBig()));

        model.addAttribute("prod", dto);
        model.addAttribute("catId", product.getCategoryId());

        PageInfo<ProductVO> list = productService.listByCategory(2, -1, null, 0, product.getCategoryId(), 1, 8);
        model.addAttribute("page", list);

        model.addAttribute("title", dto.getCode() + " " + dto.getName());
        model.addAttribute("summary", "");

        super.processBasic(model);

        return "detail";
    }

    private void setSubCategories(Integer pcatId, Model model) {
        if(pcatId != null && pcatId > 0) {
            List<Category> categories = categoryService.findChidlren(pcatId);

            model.addAttribute("subCats", categories);
        }
    }
}
