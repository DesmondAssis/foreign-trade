package com.desmond.foreigntrade;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author presleyli
 * @date 2018/12/30 5:18 PM
 */
@RunWith(SpringRunner.class)
@ContextConfiguration()
@ComponentScan({"com.desmond"})
@SpringBootTest
@Slf4j
public class BaseTest {
}
