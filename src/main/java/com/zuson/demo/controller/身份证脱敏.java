package com.zuson.demo.controller;

import org.apache.commons.lang3.StringUtils;

public class 身份证脱敏 {

  public static void main(String[] args) {

      String idcard = "372922199412299036";
      String s = encryptPhoneNo(idcard);
      System.out.println(s);

      String aa = "aa/bb";
      String[] split = aa.split("/");
    for (String s1 : split) {
      System.out.println(s1);
    }



  }

    public static String encryptPhoneNo(String phoneNo) {
        if (phoneNo == null) {
            return "";
        }
        return replaceBetween(phoneNo, 6, phoneNo.length() - 4, null);
    }

    private static String replaceBetween(String sourceStr, int begin, int end, String replacement) {
        if (sourceStr == null) {
            return "";
        }
        if (replacement == null) {
            replacement = "*";
        }
        int replaceLength = end - begin;
        if (StringUtils.isNotBlank(sourceStr) && replaceLength > 0) {
            StringBuilder sb = new StringBuilder(sourceStr);
            sb.replace(begin, end, StringUtils.repeat(replacement, replaceLength));
            return sb.toString();
        } else {
            return sourceStr;
        }
    }

}
