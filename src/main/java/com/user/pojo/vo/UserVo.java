package com.user.pojo.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author liangzhu
 * @title: UserVo
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-1408:50
 */
@Data
public class UserVo {
    private String loginName;
    private String password;
    private String userName;
    private String phone;
}
