package com.user.dao;
import com.user.pojo.*;
import com.user.pojo.vo.UserVo;
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
    int insert(User user);

    int delete(User user);

    int update(User user);

    UserVo selectById(String id);

}

