package com.desmond.foreigntrade.controller;

import com.desmond.foreigntrade.entity.Category;
import com.desmond.foreigntrade.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author presleyli
 * @date 2019/1/2 7:53 PM
 */
@Slf4j
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> listByParent(@RequestParam("parentId") Integer parentId) {
        return categoryService.findChidlren(parentId);
    }
}
