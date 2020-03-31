package com.bus.service.impl;

import com.bus.dao.RouteDao;
import com.bus.service.RouteService;
import com.common.result.Result;
import com.common.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object select(String id) {
        return new Result(ResultUtil.success(routeDao.selectById(id)));
    }
}
