package com.utils;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.bus.pojo.Bus;
import com.bus.pojo.RouteStation;
import com.bus.pojo.vo.BusVo;
import com.google.common.base.Charsets;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


public class Demo {
    public void init(String id, String rid) throws Exception {
        String url = "http://127.0.0.1:8080/busDemo/initBus" + "?id=" + id + "&rid=" + rid;
        // 创建默认的httpClient实例.
        HttpClient client = new DefaultHttpClient();
        // 创建httppost通过post方式访问
        HttpGet httpGet = new HttpGet(url);
        //作为参数发送到controller
        HttpResponse response = client.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 解析数据
            String data = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
            System.out.println("公交数据初始化：" + data);
        }
    }

    public String get(String id) throws Exception {
        String url = "http://127.0.0.1:8080/busDemo/getBus" + "?id=" + id;
        // 创建默认的httpClient实例.
        HttpClient client = new DefaultHttpClient();
        // 创建httppost通过post方式访问
        HttpGet httpGet = new HttpGet(url);
        //作为参数发送到controller
        HttpResponse response = client.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 解析数据
            String data = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
            System.out.println("获取的公交数据：" + data);
            return data;
        }
        return "获取失败";
    }

    public void update(Bus bus) throws Exception {
        String url = "http://127.0.0.1:8080/busDemo/updateBus";
        // 创建HttpClient实例
        HttpClient client = HttpClientBuilder.create().build();
        // 根据URL创建HttpPost实例
        HttpPost post = new HttpPost(url);
        // 构造post参数
        String paramJson = JSONObject.fromObject(bus).toString();
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("application/json", "UTF-8"));
        // 传入请求体
        post.setEntity(stringEntity);
        // 发送请求，得到响应体
        HttpResponse response = client.execute(post);
        // 判断是否正常返回
        if (response.getStatusLine().getStatusCode() == 200) {
            // 解析数据
            HttpEntity resEntity = response.getEntity();
            String data = EntityUtils.toString(resEntity, Charsets.UTF_8);
            System.out.println("公交数据更新情况：" + data);
        }
    }

    public String arrive(String rid, String rsid) throws Exception {
        String url = "http://127.0.0.1:8080/busDemo/busArrive" + "?rid=" + rid + "&rsid=" + rsid;
        // 创建默认的httpClient实例.
        HttpClient client = new DefaultHttpClient();
        // 创建httppost通过post方式访问
        HttpGet httpGet = new HttpGet(url);
        //作为参数发送到controller
        HttpResponse response = client.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 解析数据
            String data = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
            System.out.println("公交到站：" + data);
            return data;
        }
        return "获取失败";
    }

    public static void main(String[] args) throws Exception {

        BusAnalog busAnalog1 = new BusAnalog("A001", "1");
        BusAnalog busAnalog2 = new BusAnalog("A002", "2");
        Thread t1 = new Thread(busAnalog1);
        Thread t2 = new Thread(busAnalog2);
        t1.start();
        t2.start();
    }
}
