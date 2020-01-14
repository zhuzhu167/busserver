package com.user.pojo;

import lombok.Data;

/**
 * @author liangzhu
 * @title: User
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0815:53
 */
@Data
public class User {
    private String loginName;
    private String password;
    private String userName;
    private String phone;
    private int isUse;
}
