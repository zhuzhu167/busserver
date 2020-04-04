package com.bus.service;


public interface RouteStationService {
    String[] getStations();

    String[] getRoutes();

    String[] getRouteAllStation(String id);

    Object reAllStation(String id);

    String[] getStationAllRoute(String id);

    Object lessTransfer(String start, String end);

    Object getRoutesMsg(String name);
}
