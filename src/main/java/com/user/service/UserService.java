package com.user.service;

import com.user.pojo.User;

public interface UserService {
    Object insert(User user);

    Object delete(String id);

    Object update(User user);

    Object select(String id);

}
