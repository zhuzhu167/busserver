package com.bus.dao;

import com.bus.pojo.Route;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteStationDao {
    String[] getStation(String id);

    String[] getRoute(String id);

    String[] getStations();

    String[] getRoutes();

    String[] getRouteAllStation(String id);

    String[] getStationAllRoute(String id);

    Route[] getStationAllRouteMsg(String name);
}
