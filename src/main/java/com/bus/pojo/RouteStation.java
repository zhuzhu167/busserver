package com.bus.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RouteStation {
    private String rsid;
    private int rid;
    private List pStaId;
}
