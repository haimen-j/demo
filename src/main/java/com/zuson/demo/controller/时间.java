package com.zuson.demo.controller;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 时间 {

  public static void main(String[] args) {
      try {
          SimpleDateFormat sdf= new SimpleDateFormat();
          sdf.applyPattern("yyyy-MM-dd");
          String format = sdf.format(new Date());
          Integer substring = Integer.valueOf(format.substring(8, 10));
          for (int i = substring-1; i<= substring && i>=0;i--){
              int a  = -i;
              Date date = DateUtils.addDays(new Date(), -i);
              String format1 = sdf.format(date);
            System.out.println(format1);
          }

      } catch (Exception e) {
          e.printStackTrace();
      }

  }
}
