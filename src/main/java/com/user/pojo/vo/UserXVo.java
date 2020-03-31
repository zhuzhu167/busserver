package com.user.pojo.vo;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class UserXVo {
    @Pattern(regexp = "^[A-Za-z0-9]{6,12}$", message = "账号应为6-12位英文数字字符")
    private String loginName;

    @Pattern(regexp = "^.{8,20}$", message = "密码应为8-20位字符")
    private String password;
}
