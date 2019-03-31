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
        return processIndex(model);
    }

    @GetMapping("/")
    public String indexRedirct(Model model) {
        return processIndex(model);
    }

    private String processIndex(Model model) {
        super.processBasic(model);

        setHotProducts(model);

        model.addAttribute("title", "Most professional water sports goods like the snorkeling, diving, surfing and swimming products manufacturer in China");
        model.addAttribute("summary", "\n" +
                "PREBOOMING is one of the most professional water sports goods like the snorkeling ,diving ,surfing and swimming products manufacturer in China. We design, produce and sell full face snorkeling masks, snorkeling fins, diving wetsuit, diving mask&fin&snorkel, neoprene gloves, neoprene boots, sup, surfboard leash, rash guard, swimming goggles and swimming caps.\n" +
                "\n" +
                "Nowadays, PREBOOMING has customers in USA, Europe, South America, Australia, New Zealand ,Canada,etc. We could do OEM and ODM service for you. Olny you have any requirements,please let us know and feel free to contact us. Thank you.");


        return "index";
    }
}
