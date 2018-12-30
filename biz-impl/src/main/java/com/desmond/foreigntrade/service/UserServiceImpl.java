package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.dao.UserMapper;
import com.desmond.foreigntrade.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author presleyli
 * @date 2018/12/30 5:10 PM
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public User findByPk(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
