package com.user.dao;
import com.user.pojo.*;
import org.springframework.stereotype.Repository;

/**
 * @author liangzhu
 * @title: UserDao
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0815:52
 */
@Repository
public interface UserDao {
    public int insert(User user);
}

