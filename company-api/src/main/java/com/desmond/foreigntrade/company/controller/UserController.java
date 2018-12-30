package com.desmond.foreigntrade.company.controller;

import com.desmond.foreigntrade.entity.User;
import com.desmond.foreigntrade.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author presleyli
 * @date 2018/12/30 9:26 PM
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/hello-user")
    public String hello(Model model, @RequestParam Integer page) {
        User user = userService.findByPk(1l);

        model.addAttribute("name", user.getNickName());
        model.addAttribute("page", page);

        return "hello";
    }
}
