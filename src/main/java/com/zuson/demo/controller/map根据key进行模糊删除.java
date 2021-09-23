package com.zuson.demo.controller;

import java.util.*;

public class map根据key进行模糊删除 {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    // 抓取量存放 key：c_2018-09-27_18729  value：count
    map.put("c_2018-09-27_18729", 10);
    map.put("c_2018-09-26_18729", 20);
    map.put("c_2018-09-27_18730", 11);
    map.put("c_2018-09-25_18730", 5);
    Map<String, Integer> list = getLikeByMap(map, "c_2018-19-27");
      Iterator<String> iterator = list.keySet().iterator();
//      while (iterator.hasNext()){
//      System.out.println(list);
//      }
      System.out.println(list);
  }

  /**
   * Map集合模糊匹配
   *
   * @param map map集合
   * @param keyLike 模糊key
   * @return
   */
  public static Map<String, Integer> getLikeByMap(Map<String, Integer> map, String keyLike) {
      Iterator<String> iterator = map.keySet().iterator();
      while (iterator.hasNext()){
          String key = iterator.next();
          if (key.indexOf(keyLike)>-1){
              iterator.remove();
//              map.remove(key);
          }
      }
     /* for (Map.Entry<String, Integer> entity : map.entrySet()) {
      if (entity.getKey().indexOf(keyLike) > -1) {
        list.add((Integer) entity.getValue());

      }
    }*/
    return map;
  }


}
