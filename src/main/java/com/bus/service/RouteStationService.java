package com.bus.service;

import com.bus.pojo.RouteStation;

public interface RouteStationService {
    String[] getStations();

    String[] getRoutes();

    String[] getRouteAllStation(String id);

    Object reAllStation(String id);

    String[] getStationAllRoute(String id);

    Object lessTransfer(String start, String end);

    Object getRoutesMsg(String name);
}
