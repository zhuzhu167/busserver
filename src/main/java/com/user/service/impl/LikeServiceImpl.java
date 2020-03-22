package com.user.service.impl;

import com.common.result.Result;
import com.common.result.ResultUtil;
import com.user.dao.LikeDao;
import com.user.pojo.Like;
import com.user.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDao likeDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object insert(Object object) {
        return new Result(ResultUtil.success(likeDao.insert((Like) object)));
    }
}
