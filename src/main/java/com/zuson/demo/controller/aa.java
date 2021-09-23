package com.zuson.demo.controller;

import com.zuson.demo.entity.Student;
import com.zuson.demo.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aa {
  public static void main(String[] args) {
    Date date = strToDate("2021-03-25 00:00:00");
    Date date1 = strToDate("2021-04-25 00:00:00");
/*    long l = date1.getTime() - date.getTime();
    System.out.println(l/1000);
    double a=1000;
    double b=3000;
    double c = a/b;
    System.out.println("c===>"+c);   //1.5
    System.out.println("c===>"+Math.ceil(c)); //2.0
    System.out.println(Math.floor(c));
    int aa = 10;
    Double cc = Math.ceil(c);
    System.out.println(cc);
    List<String> list = new ArrayList<String>(){
      {
        this.add("a");
        this.add("b");
        this.add("c");
      }
    };
    System.out.println( list.subList(0,1));
//    System.out.println( list.subList(1,5));
    Date date2 = new Date();
    System.out.println(date2.getMonth()+1);*/

    List<Date> list = getDayRangeDateList(date, date1);
    for (Date date2 : list) {
      String s = toString(date2, "yyyy-MM-dd HH:00:00");
      System.out.println(s);
    }
  }

  public static List<Date> getDayRangeDateList(Date startDate, Date endDate){
    List<Date> rangDates = new ArrayList<Date>();
    if(startDate == null) {
      startDate = new Date();
    }
    if(endDate == null) {
      endDate = new Date();
    }
    String pattern = "yyyy-MM-dd 00:00:00";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    Calendar startCalendar = Calendar.getInstance();
    Calendar endCalendar = Calendar.getInstance();
    try {
      startCalendar.setTime(sdf.parse(sdf.format(startDate)));
      endCalendar.setTime(sdf.parse(sdf.format(endDate)));
    } catch (ParseException e) { // 不会出错
      e.printStackTrace();
    }
    while(startCalendar.before(endCalendar) || startCalendar.equals(endCalendar)) { // 小于等于
      rangDates.add(startCalendar.getTime());
      startCalendar.add(Calendar.DATE, 1);
    }

    return rangDates;
  }

  public static List<Date> getHourRangeDateList(Date startDate, Date endDate){
    List<Date> rangDates = new ArrayList<Date>();
    if(startDate == null) {
      startDate = new Date();
    }
    if(endDate == null) {
      endDate = new Date();
    }
    String pattern = "yyyy-MM-dd HH:00:00";
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    Calendar startCalendar = Calendar.getInstance();
    Calendar endCalendar = Calendar.getInstance();
    try {
      startCalendar.setTime(sdf.parse(sdf.format(startDate)));
      endCalendar.setTime(sdf.parse(sdf.format(endDate)));
    } catch (ParseException e) { // 不会出错
      e.printStackTrace();
    }
    while(startCalendar.before(endCalendar) || startCalendar.equals(endCalendar)) { // 小于等于
      rangDates.add(startCalendar.getTime());
      startCalendar.add(Calendar.HOUR, 1);
    }

    return rangDates;
  }


  public static int buildRandom(int length) {
    int num = 1;
    double random = Math.random();
    if (random < 0.1) {
      random = random + 0.1;
    } for (int i = 0; i < length; i++) {
      num = num * 10;
    }
    return (int) ((random * num));
  }

  public static String toString(Date date, String formaterString) {
    String time;
    SimpleDateFormat formater = new SimpleDateFormat();
    formater.applyPattern(formaterString);
    time = formater.format(date);
    return time;
  }

  public static Date strToDate(String strDate) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    ParsePosition pos = new ParsePosition(0);
    Date strtodate = formatter.parse(strDate, pos);
    return strtodate;
  }


  private static Long dayNum(Date start,Date end){
    start = DateUtils.truncate(start, Calendar.DATE);
    end = DateUtils.truncate(end, Calendar.DATE);
    long betweenDate = (end.getTime() - start.getTime())/(60*60*24*1000);
    return betweenDate;
  }

  public static Double transDouble(Double data){
    BigDecimal d = new BigDecimal(data);
    return d.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
  }

  public static Boolean testPassword(String oldPass,String newPass){
    boolean test = oldPass.equals(newPass);
    return test;
  }
  public static String publicip() {
    URL url = null;
    URLConnection urlconn = null;
    BufferedReader br = null;
    try {
      url = new URL("http://2017.ip138.com/ic.asp");//爬取的网站是百度搜索ip时排名第一的那个
      urlconn = url.openConnection();
      br = new BufferedReader(new InputStreamReader(
              urlconn.getInputStream()));
      String buf = null;
      String get= null;
      while ((buf = br.readLine()) != null) {
        get+=buf;
      }
      int where,end;
      for(where=0;where<get.length()&&get.charAt(where)!='[';where++);
      for(end=where;end<get.length()&&get.charAt(end)!=']';end++);
      get=get.substring(where+1,end);
      return get;
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  public static String getV4IP() {
    String ip = "";
    String chinaz = "http://ip.chinaz.com";

    StringBuilder inputLine = new StringBuilder();
    String read = "";
    URL url = null;
    HttpURLConnection urlConnection = null;
    BufferedReader in = null;
    try {
      url = new URL(chinaz);
      urlConnection = (HttpURLConnection) url.openConnection();
      in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
      while ((read = in.readLine()) != null) {
        inputLine.append(read + "\r\n");
      }
      //System.out.println(inputLine.toString());
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
    Matcher m = p.matcher(inputLine.toString());
    if (m.find()) {
      String ipstr = m.group(1);
      ip = ipstr;
      //System.out.println(ipstr);
    }
    return ip;
  }


}
