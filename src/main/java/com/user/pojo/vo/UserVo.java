package com.user.pojo.vo;

import lombok.Data;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserVo {
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$", message = "账号应为6-12位英文数字字符")
    private String loginName;
    @Size(min = 1, max = 30, message = "用户名格式错误，最大30位字符")
    private String userName;
    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$", message = "电话格式错误")
    private String phone;
}
