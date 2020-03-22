package com.user.dao;

import com.user.pojo.Like;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeDao {
    int insert(Like like);
}
