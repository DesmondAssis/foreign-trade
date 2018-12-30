package com.desmond.foreigntrade.service;

import com.desmond.foreigntrade.entity.User;

/**
 * @author presleyli
 * @date 2018/12/30 5:10 PM
 */
public interface UserService {
    User findByPk(Long userId);
}
