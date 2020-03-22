package com.bus.dao;

import com.bus.pojo.Station;
import org.springframework.stereotype.Repository;

@Repository
public interface StationDao {
    int insert(Station station);

    int delete(Station station);

    int update(Station station);

    Station selectById(Station station);
}
