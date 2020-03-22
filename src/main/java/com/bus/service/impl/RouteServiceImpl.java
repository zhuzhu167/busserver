package com.bus.service.impl;

import com.bus.dao.RouteDao;
import com.bus.pojo.Route;
import com.bus.service.RouteService;
import com.common.result.Result;
import com.common.result.ResultUtil;
import com.utils.MapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDao routeDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object insert(Object object) {
        Route route = MapperUtils.map(Route.class,object);
        route.setIsUse(1);
        return new Result(ResultUtil.success(routeDao.insert(route)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object delete(Object object) {
        Route route = MapperUtils.map(Route.class, object);
        return new Result(ResultUtil.success(routeDao.delete(route)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object update(Object object) {
        Route route = MapperUtils.map(Route.class, object);
        return new Result(ResultUtil.success(routeDao.update(route)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object select(Object object) {
        Route route = MapperUtils.map(Route.class, object);
        return new Result(ResultUtil.success(routeDao.selectById(route)));
    }

}
