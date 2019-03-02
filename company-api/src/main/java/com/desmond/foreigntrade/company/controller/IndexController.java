package com.desmond.foreigntrade.company.controller;

import com.desmond.foreigntrade.entity.User;
import com.desmond.foreigntrade.service.CategoryService;
import com.desmond.foreigntrade.service.UserService;
import com.desmond.foreigntrade.vo.CategoryVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author presleyli
 * @date 2018/12/30 9:26 PM
 */
@Slf4j
@Controller
public class IndexController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/index.html")
    public String index(Model model) {
        super.processBasic(model);

        return "index";
    }

    @GetMapping("/")
    public String indexRedirct(Model model) {
        super.processBasic(model);

        return "index";
    }
}
