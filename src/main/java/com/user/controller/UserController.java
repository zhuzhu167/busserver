package com.user.controller;

import com.common.result.Result;
import com.user.pojo.User;
import com.user.pojo.bo.UserBo;
import com.user.pojo.vo.UserVo;
import com.user.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * @author liangzhu
 * @title: UserController
 * @projectName busserver
 * @description: TODO
 * @date 2020-01-0816:04
 */

@RestController
@Api(description = "用户模块")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("insertUser")
    @ApiOperation(value="添加用户",response= Result.class)
    public Object insertUser(@Valid @RequestBody UserBo userBo) {
        return userService.insert(userBo);
    }

    @GetMapping("deleteUser")
    @ResponseBody
    @ApiOperation(value="删除用户",response= Result.class)
    public Object deleteUser(@NotNull @RequestParam(value = "id",required = true) String id) {
        UserVo userVo = new UserVo();
        userVo.setLoginName(id);
        return userService.delete(userVo);
    }

    @PostMapping("/updateUser")
    @ResponseBody
    @ApiOperation(value="修改用户",response= Result.class)
    public Object updateUser(@NotNull @RequestParam(value = "id",required = true) String id, @NotNull @RequestParam("name") String name) {
        UserVo userVo = new UserVo();
        userVo.setLoginName(id);
        userVo.setUserName(name);
        return userService.update(userVo);
    }

    @GetMapping("/selectUser")
    @ResponseBody
    @ApiOperation(value="查找用户",response= Result.class)
    public Object selectUser(@NotNull @RequestParam(value = "id",required = true) String id) {
        UserVo userVo = new UserVo();
        userVo.setLoginName(id);
        return userService.select(userVo);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public User test() {
        User user = new User();
        return user;
    }
}
