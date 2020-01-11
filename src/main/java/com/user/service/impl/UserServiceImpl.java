package com.user.service.impl;

import com.user.dao.UserDao;
import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liangzhu
 * @title: UserServiceImpl
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0816:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(String name) {
        User user = new User();
        user.setName(name);
        return userDao.insert(user);
    }
}
