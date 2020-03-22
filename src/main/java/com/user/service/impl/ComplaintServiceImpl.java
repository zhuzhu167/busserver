package com.user.service.impl;

import com.common.result.Result;
import com.common.result.ResultUtil;
import com.user.dao.ComplaintDao;
import com.user.pojo.Complaint;
import com.user.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintDao complaintDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object insert(Object object) {
        return new Result(ResultUtil.success(complaintDao.insert((Complaint) object)));
    }
}
