package com.bus.controller;

import com.bus.pojo.Bus;
import com.bus.service.BusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Api(description = "公交实时模拟模块")
@RequestMapping("/busDemo")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/initBus")
    @ApiOperation(value = "初始化公交数据")
    public Object initBus(@NotNull @RequestParam(value = "id", required = true) String id, @NotNull @RequestParam(value = "rid", required = true) String rid) {
        return busService.init(id, rid);
    }

    @GetMapping("/getBus")
    @ApiOperation(value = "获取公交数据")
    public Object getBus(@NotNull @RequestParam(value = "id", required = true) String id) {
        return busService.select(id);
    }

    @GetMapping("/busArrive")
    @ApiOperation(value = "公交到站")
    public Object busArrive(@NotNull @RequestParam(value = "rid", required = true) String rid,@NotNull @RequestParam(value = "rsid", required = true) String rsid) {
        return busService.arrive(rid,rsid);
    }

    @PostMapping("/updateBus")
    @ApiOperation(value = "实时更新公交数据")
    public Object updateBus(@Valid @RequestBody Bus bus) {
        return busService.update(bus);
    }
}
