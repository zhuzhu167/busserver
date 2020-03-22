package com.user.service.impl;

import com.common.result.Result;
import com.common.result.ResultUtil;
import com.user.dao.FeedbackDao;
import com.user.pojo.Feedback;
import com.user.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    public Object insert(Object object) {
        return new Result(ResultUtil.success(feedbackDao.insert((Feedback) object)));
    }
}
