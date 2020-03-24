package com.bus.pojo.vo;

import lombok.Data;

@Data
public class RouteVo {
    private String rName;
    private String rStyle;
    private String startT;
    private String endT;
    private int intervalT;
    private int charge;
    private String startSta;
    private String endSta;
}
