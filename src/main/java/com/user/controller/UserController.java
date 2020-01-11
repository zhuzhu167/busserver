package com.user.controller;

import com.common.exception.ExceptionHandle;
import com.common.result.Result;
import com.common.result.ResultUtil;
import com.user.pojo.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author liangzhu
 * @title: UserController
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0816:04
 */
@Controller("UserController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private ExceptionHandle exceptionHandle;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Object test(@RequestParam("name") String name) {
        Result result = new Result();
        try {
            if (userService.insertUser(name) == 1) {
                result = ResultUtil.success("插入成功");
            } else {
                result = ResultUtil.error(400, "插入失败");
            }
        } catch (Exception e) {
            result = this.exceptionHandle.exceptionGet(e);
        }
        return result;
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public User test1() {
        User user = new User();
        user.setName("zhuzhu");
        return user;
    }
}
