package com.desmond.foreigntrade.company.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

        model.addAttribute("title", "contact us");
        model.addAttribute("summary", "Name: Annie, Tel: 86-130-24178846, Email: annie@prebooming.com");

        return "contactus";
    }

    @GetMapping("/aboutus.html")
    public String aboutus(Model model) {
        super.processBasic(model);

        model.addAttribute("title", "about us");
        model.addAttribute("summary", "PREBOOMING is one of the most professional water sports goods like the snorkeling ,diving ,surfing and swimming products manufacturer in China. We design, produce and sell full face snorkeling masks, snorkeling fins, diving wetsuit, diving mask&fin&snorkel, neoprene gloves, neoprene boots, sup, surfboard leash, rash guard, swimming goggles and swimming caps.\n" +
                "\n" +
                "Nowadays, PREBOOMING has customers in USA, Europe, South America, Australia, New Zealand ,Canada,etc. We could do OEM and ODM service for you. Olny you have any requirements,please let us know and feel free to contact us. Thank you.");


        return "aboutus";
    }

    @GetMapping("/sitemap.html")
    public String sitemap(Model model) {
        super.processBasic(model);

        return "sitemap";
    }

    @ResponseBody
    @GetMapping("/fsgb9800.txt")
    public String roboot() {
        return "success";
    }

    @PostMapping("/subscribe.html")
    public String subscribe(Model model) {
        super.processBasic(model);

        return "redirect:index.html";
    }

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("");
        });

        t.start();
        t.start();
    }
}
