package com.user.controller;

import com.common.result.Result;
import com.user.pojo.Complaint;
import com.user.pojo.Feedback;
import com.user.pojo.Like;
import com.user.pojo.Lost;
import com.user.pojo.bo.UserBo;
import com.user.pojo.vo.UserVo;
import com.user.service.*;
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
    @Autowired
    private ComplaintService complaintService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private LostService lostService;

    @PostMapping("insertUser")
    @ApiOperation(value="添加用户",response= Result.class)
    public Object insertUser(@Valid @RequestBody UserBo userBo) {
        return userService.insert(userBo);
    }

    @DeleteMapping("deleteUser")
    @ResponseBody
    @ApiOperation(value="删除用户",response= Result.class)
    public Object deleteUser(@NotNull @RequestParam(value = "id",required = true) String id) {
        UserVo userVo = new UserVo();
        userVo.setLoginName(id);
        return userService.delete(userVo);
    }

    @PutMapping("/updateUser")
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
        return userService.select(id);
    }

    @PostMapping("/complaint")
    @ResponseBody
    @ApiOperation(value="用户投诉",response= Result.class)
    public Object complaint(@Valid @RequestBody Complaint complaint) {
        return complaintService.insert(complaint);
    }

    @PostMapping("/feedback")
    @ResponseBody
    @ApiOperation(value="用户反馈",response= Result.class)
    public Object feedback(@Valid @RequestBody Feedback feedback) {
        return feedbackService.insert(feedback);
    }

    @PostMapping("/like")
    @ResponseBody
    @ApiOperation(value="用户点赞",response= Result.class)
    public Object like(@Valid @RequestBody Like like) {
        return likeService.insert(like);
    }

    @PostMapping("/lost")
    @ResponseBody
    @ApiOperation(value="失物招领",response= Result.class)
    public Object lost(@Valid @RequestBody Lost lost) {
        return lostService.insert(lost);
    }

    @DeleteMapping("/deleteLost")
    @ResponseBody
    @ApiOperation(value="删除招领",response= Result.class)
    public Object deleteLost(@NotNull @RequestParam(value = "id",required = true) Integer id) {
        return lostService.delete(id);
    }

    @GetMapping("/findLost")
    @ResponseBody
    @ApiOperation(value="查找招领",response= Result.class)
    public Object findLost() {
        return lostService.selectAll();
    }
}
