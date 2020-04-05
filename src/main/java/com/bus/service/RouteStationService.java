package com.bus.service;


import org.apache.ibatis.annotations.Param;

public interface RouteStationService {
    String[] getStations();

    String[] getRoutes();

    String[] getRouteAllStation(String id);

    Object reAllStation(String id);

    String[] getStationAllRoute(String id);

    Object lessTransfer(String start, String end);

    Object getRoutesMsg(String name);

    Object getSEStations(String sta, String end, String rid);

    Object getSEStationsTran(String sta, String end, String tran, String rid, String ridTran);

    Object getXStations(String name);
}
