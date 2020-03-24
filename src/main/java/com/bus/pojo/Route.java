package com.bus.pojo;

import lombok.Data;

@Data
public class Route {
    private String rNum;
    private String rid;
    private String rName;
    private String rStyle;
    private String startT;
    private String endT;
    private int intervalT;
    private int charge;
    private String startSta;
    private String endSta;
    private int isUse;
}
