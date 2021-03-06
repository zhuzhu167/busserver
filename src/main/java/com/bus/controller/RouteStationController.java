package com.bus.controller;


import com.bus.service.RouteService;
import com.bus.service.RouteStationService;
import com.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@Api(description = "公交模块")
@RequestMapping("/bus")
public class RouteStationController {

    @Autowired
    private RouteStationService routeStationService;
    @Autowired
    private RouteService routeService;

    @GetMapping("/findRoute")
    @ResponseBody
    @ApiOperation(value = "查找线路", response = Result.class)
    public Object findRoute(@NotNull @RequestParam(value = "id") String id) {
        return routeService.select(id);
    }

    @GetMapping("/lessTransfer")
    @ResponseBody
    @ApiOperation(value = "少换乘", response = Result.class)
    public Object lessTransfer(@NotNull @RequestParam(value = "start") String start, @NotNull @RequestParam("end") String end) {
        return routeStationService.lessTransfer(start, end);
    }

    @GetMapping("/getRoutesMsg")
    @ResponseBody
    @ApiOperation(value = "实时站点", response = Result.class)
    public Object getRoutesMsg(@NotNull @RequestParam(value = "name") String name) {
        return routeStationService.getRoutesMsg(name);
    }

    @GetMapping("/getStations")
    @ResponseBody
    @ApiOperation(value = "获取对应路线的全部站点", response = Result.class)
    public Object getStations(@NotNull @RequestParam(value = "id") String id) {
        return routeStationService.reAllStation(id);
    }

    @GetMapping("/getSEStations")
    @ResponseBody
    @ApiOperation(value = "获取两点间站点-不换乘", response = Result.class)
    public Object getSEStations(@NotNull @RequestParam(value = "sta") String sta, @NotNull @RequestParam(value = "end") String end, @NotNull @RequestParam(value = "rid") String rid) {
        return routeStationService.getSEStations(sta, end, rid);
    }

    @GetMapping("/getSEStationsTran")
    @ResponseBody
    @ApiOperation(value = "获取两点间站点-换乘", response = Result.class)
    public Object getSEStationsTran(@NotNull @RequestParam(value = "sta") String sta, @NotNull @RequestParam(value = "end") String end, @NotNull @RequestParam(value = "tran") String tran, @NotNull @RequestParam(value = "rid") String rid, @NotNull @RequestParam(value = "ridTran") String ridTran) {
        return routeStationService.getSEStationsTran(sta, end, tran, rid, ridTran);
    }

    @GetMapping("/getXStations")
    @ResponseBody
    @ApiOperation(value = "站点模糊查询", response = Result.class)
    public Object getXStations(@NotNull @RequestParam(value = "name") String name) {
        return routeStationService.getXStations(name);
    }
}
