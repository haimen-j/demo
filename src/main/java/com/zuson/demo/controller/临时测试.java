package com.zuson.demo.controller;

import com.alibaba.fastjson.JSON;
import com.zuson.demo.TimeUtils;
import com.zuson.demo.entity.User;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class 临时测试 {

  public static void main(String[] args) {

     Integer a = 100;
      User user = new User();
      user.setId(100);
      System.out.println(a==user.getId());
  }

    public static boolean isNullOrNegativeValue(Double values){
        if (values==null){
            return true;
        }
        BigDecimal decimal = new BigDecimal(values);
        BigDecimal zero = new BigDecimal(0D);
        int i = decimal.compareTo(zero);
        if (i <=0){
            return true;
        }
        return false;
    }


    /*方法二：推荐，速度最快
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    /**
     * 两个日期相减得到的天数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getDiffDays(Date beginDate, Date endDate) {
        if (beginDate == null || endDate == null) {
            throw new IllegalArgumentException("getDiffDays param is null!");
        }
        long diff = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);
        int days = new Long(diff).intValue();
        return days;
    }

}
