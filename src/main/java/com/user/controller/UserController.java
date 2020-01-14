package com.user.controller;

import com.common.result.Result;
import com.user.pojo.User;
import com.user.pojo.vo.UserVo;
import com.user.service.UserService;
import com.utils.GetNowDate;
import com.utils.GetUUID;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    public Object insertUser(@RequestBody UserVo userVo) {
        return userService.insert(userVo);
    }

//    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
//    @ResponseBody
//    public Object deleteUser(@RequestParam(value = "id",required = true) String id) {
//        User user = new User();
//        user.setId(id);
//        return userService.delete(user);
//    }
//
//    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
//    @ResponseBody
//    public Object updateUser(@RequestParam(value = "id",required = true) String id,@RequestParam("name") String name) {
//        User user = new User();
//        user.setId(id);
//        user.setName(name);
//        return userService.update(user);
//    }
//
//    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
//    @ResponseBody
//    public Object selectUser(@RequestParam(value = "id",required = true) String id) {
//        return userService.select(id);
//    }
//
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public User test() {
        User user = new User();
        return user;
    }
}
