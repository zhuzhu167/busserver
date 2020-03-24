package com.bus.controller;

import com.bus.pojo.Notice;
import com.bus.service.NoticeService;
import com.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Api(description = "公告模块")
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("insertNotice")
    @ApiOperation(value="添加公告",response= Result.class)
    public Object insertNotice(@Valid @RequestBody Notice notice) {
        return noticeService.insert(notice);
    }

    @PostMapping("deleteNotice")
    @ApiOperation(value="删除公告",response= Result.class)
    public Object deleteNotice(@NotNull @RequestParam(value = "id",required = true) Integer id) {
        return noticeService.delete(id);
    }
}
