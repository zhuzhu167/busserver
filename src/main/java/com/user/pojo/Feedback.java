package com.user.pojo;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Feedback {
    @Pattern(regexp = "^[A-Za-z0-9]{6,12}$", message = "用户ID应为6-12位英文数字字符")
    private String userid;

    @NotNull(message = "内容不能为空")
    private String content;

    private String atime;
}
