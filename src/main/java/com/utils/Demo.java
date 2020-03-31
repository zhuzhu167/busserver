package com.utils;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


public class Demo {
    public void doGet(String name) throws IOException {
        String url = "http://127.0.0.1:8080/" + name;
        // 创建默认的httpClient实例.
        HttpClient client = new DefaultHttpClient();
        // 创建httppost通过post方式访问
        HttpGet httpGet = new HttpGet(url);
        //作为参数发送到controller
        HttpResponse response = client.execute(httpGet);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 解析数据
            String data = EntityUtils.toString(response.getEntity(), Charsets.UTF_8);
            System.out.println(data);
        }
    }

    public void doPost(String name) throws Exception {
        String url = "http://127.0.0.1:8080/" + name;
        // 创建HttpClient实例
        HttpClient client = HttpClientBuilder.create().build();
        // 根据URL创建HttpPost实例
        HttpPost post = new HttpPost(url);
        // 构造post参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name", "11"));
        // 编码格式转换
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params);
        // 传入请求体
        post.setEntity(entity);
        // 发送请求，得到响应体
        HttpResponse response = client.execute(post);
        // 判断是否正常返回
        if (response.getStatusLine().getStatusCode() == 200) {
            // 解析数据
            HttpEntity resEntity = response.getEntity();
            String data = EntityUtils.toString(resEntity);
            System.out.println(data);
        }
    }

    public static void main(String[] args) throws ClientProtocolException, IOException {
//        Demo demo = new Demo();
//        demo.doGet("user/findLost");
        //创建拥有固定线程数量的定时线程任务的线程池
        ScheduledExecutorService es4 = Executors.newScheduledThreadPool(10);
        System.out.println("时间：" + System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            es4.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("时间：" + System.currentTimeMillis() + "--" + Thread.currentThread().getName() + "正在执行任务");
                }
            }, 3, TimeUnit.SECONDS);
        }
    }
}
