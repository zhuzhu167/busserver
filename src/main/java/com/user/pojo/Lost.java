package com.user.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class Lost {
    @NotNull(message = "丢失时间不能为空")
    private Date losttime;

    @NotNull(message = "标题不能为空")
    private String title;

    @NotNull(message = "内容不能为空")
    private String content;

    @NotNull(message = "类型不能为空")
    private String style;

    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$", message = "电话格式错误")
    private String contactNum;

    @Pattern(regexp = "^[A-Za-z0-9]{6,12}$", message = "用户ID应为6-12位英文数字字符")
    private String contactId;
}
