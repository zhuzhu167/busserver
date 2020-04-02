package com.bus.pojo;

import lombok.Data;

import java.sql.Time;

@Data
public class Bus {
    private String id;
    private String rid;
    private String now_sta;
    private double next_dis;
    private double next_t;
    private int now_sta_no;
    private double now_dis;
    private String start_t;
    private double all_dis;
    private double all_t;
    private double late;
}
