package com.bus.service.impl;


import com.bus.dao.BusDao;
import com.bus.pojo.Bus;
import com.bus.pojo.RouteStation;
import com.bus.service.BusService;
import com.common.result.Result;
import com.common.result.ResultUtil;
import com.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusDao busDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object init(String id, String rid) {
        return busDao.init(id, rid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object update(Object object) {
        return busDao.update((Bus) object);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object select(String id) {
        return busDao.select(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object arrive(String rid,String rsid) {
        return busDao.selectNextSta(rid,rsid);
    }
}
