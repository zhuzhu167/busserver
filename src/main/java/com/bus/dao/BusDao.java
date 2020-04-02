package com.bus.dao;

import com.bus.pojo.Bus;
import com.bus.pojo.RouteStation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BusDao {
    int init(String id, String rid);

    int update(Bus bus);

    Bus select(String id);

    Bus selectNextSta(@Param("rid")String rid, @Param("rsid")String rsid);
}
