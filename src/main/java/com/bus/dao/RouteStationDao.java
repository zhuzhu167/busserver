package com.bus.dao;

import com.bus.pojo.Route;
import com.bus.pojo.RouteStation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteStationDao {
    String[] getStation(String id);

    String[] getRoute(String id);

    String[] getStations();

    String[] getRoutes();

    String[] getRouteAllStation(String id);

    String[] getStationAllRoute(String id);

    Route[] getStationAllRouteMsg(@Param("name") String name);

    String[] getSEStations(@Param("sta") String sta, @Param("end") String end, @Param("rid") String rid);

    String[] getSEStationsTran(@Param("sta") String sta, @Param("end") String end, @Param("tran") String tran, @Param("rid") String rid, @Param("ridTran") String ridTran);

    RouteStation[] getXStations(@Param("name") String name);
}
