package com.bus.dao;

import com.bus.pojo.RouteStation;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteStationDao {
    int insert(RouteStation routeStation);

    int delete(RouteStation routeStation);

    int update(RouteStation routeStation);

    RouteStation selectById(RouteStation routeStation);
}
