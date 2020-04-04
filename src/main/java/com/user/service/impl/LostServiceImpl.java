package com.user.service.impl;

import com.common.result.Result;
import com.common.result.ResultUtil;
import com.user.dao.LostDao;
import com.user.pojo.Lost;
import com.user.service.LostService;
import com.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LostServiceImpl implements LostService {

    @Autowired
    private LostDao lostDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object insert(Object object) {
        Lost lost = MapperUtils.map(Lost.class, object);
        return new Result(ResultUtil.success(lostDao.insert(lost)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object delete(Integer id) {
        return new Result(ResultUtil.success(lostDao.delete(id)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object selectAll() {
        return new Result(ResultUtil.success(lostDao.selectAll()));
    }
}
