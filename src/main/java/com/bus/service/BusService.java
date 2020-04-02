package com.bus.service;

import com.bus.pojo.Bus;

public interface BusService {
    Object init(String id, String rid);

    Object update(Object object);

    Object select(String id);

    Object arrive(String rid,String rsid);
}
