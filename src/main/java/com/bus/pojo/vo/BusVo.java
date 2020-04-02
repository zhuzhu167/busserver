package com.bus.pojo.vo;

import lombok.Data;

@Data
public class BusVo {
    private String id;
    private String now_sta;
    private int now_sta_no;
    private double next_dis;
    private double next_t;
    private double now_dis;
    private double late;
}
