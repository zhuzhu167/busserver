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
    public Object insert(User user) {
        return new Result(ResultUtil.success(userDao.insert(user)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object delete(String id) {
        return new Result(ResultUtil.success(userDao.delete(id)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object update(User user) {
        return new Result(ResultUtil.success(userDao.update(user)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object select(String id) {
        return new Result(ResultUtil.success(userDao.selectById(id)));
    }
}
