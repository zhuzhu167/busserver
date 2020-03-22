package com.bus.dao;

import com.bus.pojo.Route;
import com.bus.pojo.vo.RouteVo;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDao {
    int insert(Route route);

    int delete(Route route);

    int update(Route route);

    RouteVo selectById(Route route);
}
