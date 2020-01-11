package com.user.service.impl;

import com.common.result.Result;
import com.common.result.ResultUtil;
import com.user.dao.UserDao;
import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object insertUser(String name) {
        Result result;
//        try {
            User user = new User();
            user.setName(name);
            result = ResultUtil.success(userDao.insertUser(user));
//        } catch (Exception e) {
//            System.out.println(e+"---------------------------------");
//            result = ResultUtil.error(401, "插入失败");
//        }
        return result;
    }
}
