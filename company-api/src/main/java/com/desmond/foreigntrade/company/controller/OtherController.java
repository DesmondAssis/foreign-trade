package com.desmond.foreigntrade.company.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author presleyli
 * @date 2019/3/2 8:18 PM
 */
@Slf4j
@Controller
public class OtherController extends BaseController {
    @GetMapping("/contactus.html")
    public String contactus(Model model) {
        super.processBasic(model);

        return "contactus";
    }

    @GetMapping("/aboutus.html")
    public String aboutus(Model model) {
        super.processBasic(model);

        return "aboutus";
    }

    @GetMapping("/sitemap.html")
    public String sitemap(Model model) {
        super.processBasic(model);

        return "sitemap";
    }

    @PostMapping("/subscribe.html")
    public String subscribe(Model model) {
        super.processBasic(model);

        return "redirect:index.html";
    }
}
