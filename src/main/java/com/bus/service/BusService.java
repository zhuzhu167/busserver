package com.bus.service;

public interface BusService {
    Object init(String id, String rid);

    Object update(Object object);

    Object select(String id);

    Object arrive(String rid,String rsid);
}
