package com.zuson.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.collections.MappingChange;
import com.zuson.demo.entity.AddressInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;

import java.util.Map;

public class 反编译位置信息 {

      public static void main(String[] args) {
          double a = 115.54863;
          double b = 34.840603;
          longitudeToAddress(b,a);
          AddressTolongitudea("山东省菏泽曹县");
      }


    /**
     * 逆地理编码 URL
     */
    final static String LONGITUDE_TO_ADDRESS_URL = "http://api.map.baidu.com/reverse_geocoding/v3/?output=json&coordtype=BD09&pois=1";

    /**
     * 逆地理编码
     * @param lat
     *        纬度 23.1067,
     * @param lng
     *        经度 113.325
     * @return
     */
    public  static void longitudeToAddress(double lat, double lng) {
        String AK ="NUuInjQgUoZGZQwnwQuIwvUCw2iPTs1c";
        //根据经纬度获取地理位置信息
        String url = LONGITUDE_TO_ADDRESS_URL + "&ak=" + AK + "&location=" + lat + "," + lng;
        //根据地理位置信息查询经纬度
//        String url = ADDRESS_TO_LONGITUDEA_URL + "&ak=" + AK + "&address="+ address;
        HttpClient client = HttpClients.createDefault(); // 创建默认http连接
        HttpPost post = new HttpPost(url);// 创建一个post请求

        try {

            HttpResponse response = client.execute(post);// 用http连接去执行get请求并且获得http响应
            HttpEntity entity = response.getEntity();// 从response中取到响实体
            String html = EntityUtils.toString(entity);// 把响应实体转成文本
            System.out.println("返回信息：" + html);
            // JSON转对象
//            return JSON.parseObject(html, ReturnLocationBean.class);
            Map map = JSON.parseObject(html, Map.class);
            Object result = map.get("result");
            AddressInfo addressInfo = JSONObject.parseObject(JSON.toJSONString(result), AddressInfo.class);
            /*AddressInfo info = new AddressInfo();
            BeanUtils.copyProperties(result,info);*/
            System.out.println(addressInfo);
        } catch (Exception e) {

            System.out.println("逆地理编码[异常],"+e);
        }

    }
    /**
     * http://lbsyun.baidu.com/apiconsole/key
     * <百度开发者>用户申请注册的key，自v2开始参数修改为“ak”，之前版本参数为“key” 申请ak
     */
    final static String AK = "edGc5mIugVxx7lwUx9YpraKeWmExG64o";


    /**
     * 地理编码 URL
     */
    final static String ADDRESS_TO_LONGITUDEA_URL = "http://api.map.baidu.com/geocoding/v3/?output=json&location=showLocation";

  /**
   * 地理编码
   *
   * @param address (广东省广州市黄埔区) 详细的位置信息
   * @return
   */
  public static void AddressTolongitudea(String address) {

    if (StringUtils.isBlank(address)) {

      return;
    }

    String url = ADDRESS_TO_LONGITUDEA_URL + "&ak=" + AK + "&address=" + address;
    //        log.info("请求url:" + url);
    HttpClient client = HttpClients.createDefault(); // 创建默认http连接
    HttpPost post = new HttpPost(url); // 创建一个post请求

    try {
      HttpResponse response = client.execute(post); // 用http连接去执行get请求并且获得http响应
      HttpEntity entity = response.getEntity(); // 从response中取到响实体
      String html = EntityUtils.toString(entity); // 把响应实体转成文本
      //            log.info("返回信息：" + html);
      // JSON转对象
        Map map = JSON.parseObject(html, Map.class);
        Object result = map.get("result");
        AddressInfo addressInfo = JSONObject.parseObject(JSON.toJSONString(result), AddressInfo.class);
        Map<String, Double> location = addressInfo.getLocation();
        System.out.println(addressInfo);
        System.out.println("lng:"+location.get("lng"));
        System.out.println("lat:"+location.get("lat"));
    } catch (Exception e) {
      //
      //            log.error("地理编码[异常],", e);
      //            return null;
    }
}
}


