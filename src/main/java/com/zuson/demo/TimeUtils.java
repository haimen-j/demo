package com.zuson.demo;

import com.zuson.demo.strawVideo.service.impl.ExceptionUtils;
import com.zuson.demo.strawVideo.service.impl.LogUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ProjectName: alarm-analysis
 * @Package: com.ldst.eco.common.utils.timeUtil
 * @Author: sunpeizhu
 * @Date: 2020/07/22 8:26
 * @Version: 1.0
 */
public class TimeUtils {

    public final static String DATE_FORMAT_DAY = "yyyy-MM-dd";

    public final static String DATE_FORMAT_HOUR = "yyyy-MM-dd HH";

    public final static String DATE_FORMAT_MIN = "yyyy-MM-dd HH:mm";

    public final static String DATE_FORMAT_SEC = "yyyy-MM-dd HH:mm:ss";

    public final static String DATE_FORMAT_HOUR_C = "yyyy年MM月dd日HH时";

    /**
     * 格式化时间 yyyy-MM-dd
     * @param date
     * @return
     */
    public static String DateToStr(Date date) {
        return DateToStr(date,TimeUtils.DATE_FORMAT_DAY);
    }

    /**
     * 将时间按照传入的格式进行格式化
     *
     * @param date
     * @param formaterString
     * @return
     */
    public static String DateToStr(Date date, String formatString) {
        String time;
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(formatString);
        time = format.format(date);
        return time;
    }

    /**
     * 将字符串转换成date yyyy-MM-dd
     * @param dateStr
     * @return
     */
    public static Date StrToDate(String dateStr) {
        return StrToDate(dateStr,TimeUtils.DATE_FORMAT_DAY);
    }
    /**
     * 按提供的格式将字符串转换成Date
     * @param dateStr   时间字符串
     * @param formaterString  时间格式
     * @return
     */
    public static Date StrToDate(String dateStr, String formaterString) {
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

    /**
     * 修改时间的小时值，返回新时间，整数增加小时，负数减少小时
     * @param date
     * @param number
     * @return
     */
    public static Date addHour(Date date,int number){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR,number); //把小时往后增加number,负数往前移动
        return calendar.getTime();
    }

    public static Date getNowDate(){
        return new Date();
    }

    public static long hourToMillis(int hour) {
		return hour * 60 * 60 * 1000;
	}

	//获取两个时间之间的小时数
    public static int getHourNum(Date beginDate, Date endDate) {
        if (beginDate==null ||  endDate==null){
            return -1;
        }
        long time = endDate.getTime()-beginDate.getTime();
        int hourNum = (int) (time / 1000 / 3600);
        return hourNum;
    }


    public static String culTimeHour(Date date,Integer num){
        if (date==null){
            return null;
        }
        if (num==null) num =0;
        String str = null;
        try {
            str = DateToStr(DateUtils.addHours(date, num), "yyyy-MM-dd HH:mm:ss");
        }catch (Exception e){
        }
        return str;
    }



    /**
     * 判断时间是否在区间时间范围之内
     * @param begin 开始区间
     * @param end  结束区间
     * @param source 要判断的时间
     * @return
     */
    public static Boolean isInTimeOfRang(Date begin,Date end, Date source){
        if (null ==begin && null == end) return null;
        if (null !=begin && null != end && begin.getTime()< source.getTime() && end.getTime()>source.getTime())
            return true;
        if (null ==begin && end.getTime()>source.getTime()) return true;
        if (null == end && begin.getTime()< source.getTime()) return true;
        return false;
    }

}
