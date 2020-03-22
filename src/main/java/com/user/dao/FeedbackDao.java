package com.user.dao;

import com.user.pojo.Feedback;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackDao {
    int insert(Feedback feedback);
}
