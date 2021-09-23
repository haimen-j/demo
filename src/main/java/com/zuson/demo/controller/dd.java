package com.zuson.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dd {

  public static void main(String[] args) {

      Date date = toDate("2021-01-28 12:30:01", "yyyy-MM-dd HH:mm:ss");
      Date date1 = toDate("2021-01-28 12:30:00", "yyyy-MM-dd HH:mm:ss");
      long l = dateDiff(date1, date);
    System.out.println(l);
  }

    public static long dateDiff(Date beginDate, Date endDate) {
        long date1ms = beginDate.getTime();
        long date2ms = endDate.getTime();
        return date2ms - date1ms;
    }

    public static Date toDate(String dateStr, String formaterString) {
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern(formaterString);
        try {
            date = formater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
