package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.BaseTest;
import com.desmond.foreigntrade.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author presleyli
 * @date 2018/12/30 5:21 PM
 */
public class UserServiceTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void findByPk() {
        User user = userService.findByPk(1l);

        Assert.assertNotNull(user);
    }
}
