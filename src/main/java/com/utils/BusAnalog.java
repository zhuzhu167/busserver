package com.utils;

import com.alibaba.fastjson.JSON;
import com.bus.pojo.Bus;
import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BusAnalog implements Runnable {

    private String Id;
    private String route;

    public BusAnalog(String id,String route) {
        this.Id = id;
        this.route = route;
    }

    @SneakyThrows
    public void run() {
        play();
    }

    public void play() throws Exception {
        Demo demo = new Demo();
        // 当前准备出发的公交实例
        // 公交行驶速度 米/每五秒
        Double v = 14.1;
        Double s = 0.0;
        Double now_s = 0.0;
        // 发车
        demo.init(this.Id, this.route);
        Random random = new Random(100);
        while (true) {
            // 查找对象
            Bus busSelect = new Bus();
            // 更新对象
            Bus busUpdate = new Bus();
            busUpdate.setId(this.Id);
            // 到站对象
            Bus busArrive = new Bus();
            v = 14.1;
            // 查找对象
            busSelect = JSON.parseObject(demo.get(this.Id), Bus.class);
            System.out.println(this.Id + "号公交正在行驶情况：" + busSelect.getNow_dis() + "/" + busSelect.getNext_dis());


            // 到终点站
            if (s > busSelect.getAll_dis()) {
                System.out.println("到终点站：" + busSelect.getNow_sta());
            }
            // 判断公交是否到站
            if (now_s > busSelect.getNext_dis()) {
                // 设置站点号
                int no = busSelect.getNow_sta_no() + 1;
                // 到站对象
                busArrive = JSON.parseObject(demo.arrive(busSelect.getRid(), String.valueOf(no)), Bus.class);
                // 设置当前距离
                busArrive.setNow_sta_no(no);
                busArrive.setNow_dis(0);
                busArrive.setId(this.Id);
                demo.update(busArrive);
                now_s = 0.0;
                continue;
            }


            // 正常行驶
            TimeUnit.SECONDS.sleep(5);//秒
            now_s += v * 5;
            s += v * 5;
            busUpdate.setNow_dis(now_s);
            demo.update(busUpdate);


            // 遇到塞车
            int ran = random.nextInt(100);
            if (ran > 97) {
                System.out.println(busSelect.getId() + "号车遇到大塞车");
                busUpdate.setLate(3);
                demo.update(busUpdate);
                TimeUnit.MINUTES.sleep(3);
            } else if (ran > 94) {
                System.out.println(busSelect.getId() + "号车遇到小塞车");
                busUpdate.setLate(1);
                demo.update(busUpdate);
                TimeUnit.SECONDS.sleep(60);
            } else if (ran > 88) {
                System.out.println(busSelect.getId() + "号车到了车速缓慢路段");
                v = 11.0;
            } else {
                System.out.println(busSelect.getId() + "号车正常行驶--" + ran);
            }
        }
    }
}
