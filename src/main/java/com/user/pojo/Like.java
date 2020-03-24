package com.user.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Like {
    @Pattern(regexp = "^[A-Za-z0-9]{6,12}$", message = "用户ID应为6-12位英文数字字符")
    private String userid;

    @NotNull(message = "点赞路线不能为空")
    private String like_route;

    private String like_carNum;
}
