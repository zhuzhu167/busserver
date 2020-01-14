package com.user.service;

import com.user.pojo.vo.UserVo;

public interface UserService {
    Object insert(Object object);

    Object delete(Object object);

    Object update(Object object);

    Object select(String id);

}
