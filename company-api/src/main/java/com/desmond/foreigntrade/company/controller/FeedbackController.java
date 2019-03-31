package com.desmond.foreigntrade.company.controller;

import com.desmond.foreigntrade.company.form.FeedbackForm;
import com.desmond.foreigntrade.dto.FeedbackDTO;
import com.desmond.foreigntrade.entity.Product;
import com.desmond.foreigntrade.entity.User;
import com.desmond.foreigntrade.service.CategoryService;
import com.desmond.foreigntrade.service.InquireService;
import com.desmond.foreigntrade.service.ProductService;
import com.desmond.foreigntrade.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author presleyli
 * @date 2018/12/30 9:26 PM
 */
@Slf4j
@Controller
public class FeedbackController extends BaseController {
    @Autowired
    private ProductService productService;

    @Autowired
    private InquireService inquireService;

    @GetMapping("/feedback.html")
    public String getDetail(Model model, FeedbackForm feedbackForm) {

        this.processDetail(model, feedbackForm);

        super.processBasic(model);

        model.addAttribute("title", "feedback");
        model.addAttribute("summary", "PREBOOMING is one of the most professional water sports goods like the snorkeling ,diving ,surfing and swimming products manufacturer in China. We design, produce and sell full face snorkeling masks, snorkeling fins, diving wetsuit, diving mask&fin&snorkel, neoprene gloves, neoprene boots, sup, surfboard leash, rash guard, swimming goggles and swimming caps.\n" +
                "\n" +
                "Nowadays, PREBOOMING has customers in USA, Europe, South America, Australia, New Zealand ,Canada,etc. We could do OEM and ODM service for you. Olny you have any requirements,please let us know and feel free to contact us. Thank you.");

        return "feedback";
    }

    @PostMapping("/feedback.html")
    public String postDetail(Model model, FeedbackForm feedbackForm) {

        this.processDetail(model, feedbackForm);

        super.processBasic(model);

        return "feedback";
    }

    private void processDetail(Model model, FeedbackForm feedbackForm) {
        List<Integer> idList = new ArrayList<>();

        if(feedbackForm.getSpSelected() != null) {
            idList.add(feedbackForm.getSpSelected());
        }

        if(!CollectionUtils.isEmpty(feedbackForm.getPSelected())) {
            idList.addAll(feedbackForm.getPSelected());
        }

        List<Product> products = productService.getByPks(idList);

        if(!CollectionUtils.isEmpty(products)) {
            String ids = String.join(",", products.stream()
                    .map(Product::getId)
                    .map(String::valueOf).collect(Collectors.toList()));

            String names = String.join("<br>", products.stream()
                    .map(o -> o.getCode() + " " + o.getName())
                    .collect(Collectors.toList()));

            model.addAttribute("ids", ids);
            model.addAttribute("names", names);
        }
    }

    @PostMapping(value = "/feedback-send.html")
    @ResponseBody
    public String fill(@RequestBody FeedbackDTO dto) {
        inquireService.add(dto);

        return "success";
    }
}
