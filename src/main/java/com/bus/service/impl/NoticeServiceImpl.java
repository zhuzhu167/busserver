package com.bus.service.impl;

import com.bus.dao.NoticeDao;
import com.bus.pojo.Notice;
import com.bus.service.NoticeService;
import com.common.result.Result;
import com.common.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object insert(Object object) {
        return new Result(ResultUtil.success(noticeDao.insert((Notice) object)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object delete(Integer id) {
        return new Result(ResultUtil.success(noticeDao.delete(id)));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object selectAll() {
        return new Result(ResultUtil.success(noticeDao.selectAll()));
    }
}
