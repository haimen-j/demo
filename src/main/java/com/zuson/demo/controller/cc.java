package com.zuson.demo.controller;

import com.github.pagehelper.util.StringUtil;
import com.zuson.demo.entity.Student;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class cc {

    public static void main(String[] args){
        Date parse = null;
//        Date date = DateUtils.truncate(new Date(), Calendar.HOUR);
        Date date = new Date();
        try {
            SimpleDateFormat sdf= new SimpleDateFormat();
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
            parse = sdf.parse("2021-05-14 14:52:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long  mills = date.getTime()-parse.getTime();
        int requiredHours = (int) (mills / 1000/60);
        System.out.println(requiredHours);
    System.out.println("=============================================================================");
        int diffDays = getHourNum(parse,date );
        System.out.println(diffDays);
        String[] a = {"1","2","3","4","5","6"};
        String[] b = {"1","2","3"};
        List<String> aa = new ArrayList<>(Arrays.asList(a));
        List<String> bb = new ArrayList<>(Arrays.asList(b));
        /*for (String s : aa) {
            if (s.equals("1"))
            aa.removeIf(p ->p.equals(s));
        }*/
        aa.removeIf(p -> p.contains("1,2"));
        String join = StringUtils.join(aa, ",");
        System.out.println("String"+join);
        /*if (aa.contains("1")){
      System.out.println(11111111);

        }*/
        System.out.println(aa);
        System.out.println("=================================");
     /*   List<String> bb = Arrays.asList(b);
        Set<String> cc = new HashSet<>();
        cc.addAll(aa);
        cc.addAll(bb);
        String join = StringUtils.join(cc.toArray(), ",");
        System.out.println(cc);
        System.out.println(join);*/
    }
    public static int getHourNum(Date beginDate, Date endDate) {
        long time = endDate.getTime()-beginDate.getTime();
        int hourNum = (int) (time / 1000 / 3600);
        return hourNum;
    }



}
