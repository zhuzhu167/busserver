package com.bus.controller;

import com.bus.pojo.vo.RouteVo;
import com.bus.pojo.bo.RouteBo;
import com.bus.service.RouteService;
import com.common.result.Result;
import com.utils.MapperUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Api(description = "路线模块")
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("insertRoute")
    @ApiOperation(value="添加路线",response= Result.class)
    public Object insertRoute(@Valid @RequestBody RouteBo routeBo) {
        return routeService.insert(routeBo);
    }

    @DeleteMapping("deleteRoute")
    @ResponseBody
    @ApiOperation(value="删除路线",response= Result.class)
    public Object deleteRoute(@NotNull @RequestParam(value = "id",required = true) String id) {
        RouteBo routeBo = new RouteBo();
        routeBo.setRNum(id);
        return routeService.delete(routeBo);
    }

    @PutMapping("updateRoute")
    @ResponseBody
    @ApiOperation(value = "修改路线",response = Result.class)
    public  Object updateRoute(@NotNull @RequestParam(value = "id",required = true) String id, @Valid @RequestBody RouteVo routeVo){
        RouteBo routeBo = MapperUtils.map(RouteBo.class,routeVo);
        routeBo.setRNum(id);
        return routeService.update(routeBo);
    }

    @GetMapping("/selectRoute")
    @ResponseBody
    @ApiOperation(value="查找路线",response= Result.class)
    public Object selectRoute(@NotNull @RequestParam(value = "id",required = true) String id) {
        RouteBo routeBo = new RouteBo();
        routeBo.setRNum(id);
        return routeService.select(routeBo);
    }
}
