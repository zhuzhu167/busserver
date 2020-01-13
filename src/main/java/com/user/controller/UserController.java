package com.user.controller;

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

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    @ResponseBody
    public Object insertUser(@RequestParam(value = "id",required = true) String id,@RequestParam("name") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return userService.insert(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteUser(@RequestParam(value = "id",required = true) String id) {
        User user = new User();
        user.setId(id);
        return userService.delete(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    @ResponseBody
    public Object updateUser(@RequestParam(value = "id",required = true) String id,@RequestParam("name") String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return userService.update(user);
    }

    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    @ResponseBody
    public Object selectUser(@RequestParam(value = "id",required = true) String id) {
        return userService.select(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public User test() {
        User user = new User();
        user.setName("zhuzhu");
        return user;
    }
}
