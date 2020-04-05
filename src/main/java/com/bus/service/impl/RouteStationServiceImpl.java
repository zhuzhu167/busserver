package com.bus.service.impl;

import com.bus.dao.RouteStationDao;
import com.bus.service.RouteStationService;
import com.common.result.Result;
import com.common.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteStationServiceImpl implements RouteStationService {

    @Autowired
    private RouteStationDao routeStationDao;

    @Override
    public String[] getStations() {
        return routeStationDao.getStations();
    }

    @Override
    public String[] getRoutes() {
        return routeStationDao.getRoutes();
    }

    @Override
    public String[] getRouteAllStation(String id) {
        return routeStationDao.getRouteAllStation(id);
    }

    @Override
    public Result reAllStation(String id) {
        return new Result(ResultUtil.success(routeStationDao.getRouteAllStation(id)));
    }

    @Override
    public String[] getStationAllRoute(String id) {
        return routeStationDao.getStationAllRoute(id);
    }


    @Override
    public Object getRoutesMsg(String name) {
        return new Result(ResultUtil.success(routeStationDao.getStationAllRouteMsg(name)));
    }

    @Override
    public Object getSEStations(String sta, String end, String rid) {
        return new Result(ResultUtil.success(routeStationDao.getSEStations(sta, end, rid)));
    }

    @Override
    public Object getSEStationsTran(String sta, String end, String tran, String rid, String ridTran) {
        return new Result(ResultUtil.success(routeStationDao.getSEStationsTran(sta, end, tran, rid, ridTran)));
    }

    @Override
    public Object getXStations(String name) {
        return new Result(ResultUtil.success(routeStationDao.getXStations(name)));
    }

    @Override
    public Result lessTransfer(String start, String end) {
        boolean start_flag, end_flag;
        start_flag = false;
        end_flag = false;
        String station_total[] = this.getStations();
        String busline_total[] = this.getRoutes();
        // 判断数据库中是否有此站点
        for (int i = 0; i < station_total.length; i++) {
            if (start.equals(station_total[i]))
                start_flag = true;
            if (end.equals(station_total[i]))
                end_flag = true;
            if (start_flag && end_flag)
                break;
        }
        if (!(start_flag && end_flag)) {
            return new Result(ResultUtil.success(404, "参数错误", "站点不存在"));
        }
        // 两个站点都存在的情况
        // 首先判断有无直达车
        String line_temp = "";
        for (int j = 0; j < busline_total.length; j++) {
            int direct_flag = 0;
            String station_per_line[] = this.getRouteAllStation(busline_total[j]);
            for (int k = 0; k < station_per_line.length; k++) {
                if (start.equals(station_per_line[k]))
                    direct_flag++;
                if (end.equals(station_per_line[k]))
                    direct_flag++;
                if (direct_flag == 2) {
                    System.out.println("有直达");
                    break;
                }
            }
            if (direct_flag == 2) {
                line_temp = busline_total[j];
                return new Result(ResultUtil.success(line_temp + "号线直达"));
            }
        }
        // 没有直达车
        if (line_temp == "") {
            System.out.println("没有直达车，下面进行一次中转的算法");
            String start_pass[] = this.getStationAllRoute(start);
            String end_pass[] = this.getStationAllRoute(end);
            String station_temp = "";// 用来保存站点用的，最后用+连成路径，一次输出三个站点
            for (int s = 0; s < start_pass.length; s++) {
                for (int e = 0; e < end_pass.length; e++) {
                    // 判断两条线路有没有交叉点
                    String start_per_line[] = this.getRouteAllStation(start_pass[s]);
                    String end_per_line[] = this.getRouteAllStation(end_pass[e]);
                    for (int ss = 0; ss < start_per_line.length; ss++)
                        for (int ee = 0; ee < end_per_line.length; ee++) {
                            if ((start_per_line[ss]).equals(end_per_line[ee])) {
                                // 成功找到交叉点后
                                // 存储交叉点处信息
                                // 此只为一次换乘
                                String first_line = start_pass[s];
                                String second_line = end_pass[e];
                                String change_station = start_per_line[ss];
                                station_temp += first_line + "-"
                                        + second_line + "-" + change_station + "-";
                                return new Result(ResultUtil.success(station_temp));
                            }
                        }
                }
            }
            if (station_temp != "") return new Result(ResultUtil.success(404, "参数错误", "找不到线路"));
        }
        return new Result(ResultUtil.success("没有找到对应线路"));
    }
}
