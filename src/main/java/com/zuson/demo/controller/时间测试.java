package com.zuson.demo.controller;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class 时间测试 {

  public static void main(String[] args) {
      Date truncate = DateUtils.truncate(new Date(), Calendar.HOUR);
      Date dateEnd = DateUtils.addHours(truncate, 0);
      Date dateStart = DateUtils.addHours(truncate, -2);
      Date dateBeforeStart = DateUtils.addHours(truncate, -3);
      String s = toString(truncate, "yyyy-MM-dd HH:mm:ss");
      String s1 = toString(dateEnd, "yyyy-MM-dd HH:mm:ss");
      String s2 = toString(dateStart, "yyyy-MM-dd HH:mm:ss");
      String s3 = toString(dateBeforeStart, "yyyy-MM-dd HH:mm:ss");
    System.out.println(s);
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);



  }

    public static String toString(Date date, String formaterString) {
        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern(formaterString);
        time = formater.format(date);
        return time;
    }

}
