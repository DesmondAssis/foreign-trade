package com.desmond.foreigntrade.service.mail;

import com.desmond.foreigntrade.BaseTest;
import com.desmond.foreigntrade.entity.Product;
import com.desmond.foreigntrade.service.EmailService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by presleyli on 2018/10/8.
 */
public class EmailServiceTest extends BaseTest {
    @Autowired
    private EmailService emailService;

    @Test
    public void sendEmail() throws Exception {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("name", "Presley");
        modelMap.put("email", "code-x");
        modelMap.put("message", "message-");
        modelMap.put("products", Arrays.asList(getProduct(), getProduct()));

        emailService.sendEmail(null, new String[]{"xcli@86links.com","devtiger@163.com"}, null,
                "【产品询盘】新的询盘", "inquire.ftl", modelMap
        );

        Assert.assertTrue(true);
    }

    private Product getProduct() {
        Product product = new Product();
        product.setName("prd-name");
        product.setId(1);
        product.setCode("code");

        return product;
    }
}