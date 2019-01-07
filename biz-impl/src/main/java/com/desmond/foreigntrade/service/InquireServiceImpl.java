package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.config.MailConfig;
import com.desmond.foreigntrade.dao.InquireMapper;
import com.desmond.foreigntrade.dao.InquireProductMapper;
import com.desmond.foreigntrade.dao.UserMapper;
import com.desmond.foreigntrade.dto.FeedbackDTO;
import com.desmond.foreigntrade.entity.Inquire;
import com.desmond.foreigntrade.entity.InquireProduct;
import com.desmond.foreigntrade.entity.Product;
import com.desmond.foreigntrade.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author presleyli
 * @date 2018/12/30 5:10 PM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class InquireServiceImpl implements InquireService {
    private final InquireMapper userMapper;
    private final InquireProductMapper inquireProductMapper;
    private final ProductService productService;
    private final EmailService emailService;
    private final MailConfig mailConfig;

    public Boolean add(FeedbackDTO feedback) {
        Inquire inquire = new Inquire();
        BeanUtils.copyProperties(feedback, inquire);

        userMapper.insertSelective(inquire);

        // ref
        List<Product> productList = new ArrayList<>();
        if(StringUtils.isNotBlank(feedback.getProducts())) {
            String[] arr = feedback.getProducts().split(",");

            for(String id : arr) {
                Product prod = productService.getDetail(NumberUtils.toInt(id));
                if(prod != null) {
                    InquireProduct product = new InquireProduct();
                    product.setInquireId(inquire.getId());
                    product.setProductId(prod.getId());
                    product.setCode(prod.getCode());
                    product.setName(prod.getName());

                    inquireProductMapper.insertSelective(product);

                    productList.add(prod);
                }
            }
        }

        // send email
        String[] emailArr = mailConfig.getReciever().split(",");

        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("name", feedback.getGuestName());
        modelMap.put("email", feedback.getGuestEmail());
        modelMap.put("message", feedback.getGuestMessage());
        modelMap.put("products", productList);

        emailService.sendEmail(null, emailArr, null,
                "任务确认", "inquire.ftl", modelMap
        );

        return true;
    }
}
