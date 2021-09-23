package com.zuson.demo.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import sun.misc.BASE64Encoder;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DocUtil {
    /**
     * 根据Doc模板生成word文件
     * @param dataMap 需要填入模板的数据
     * @param downloadType 文件名称
     * @param savePath 保存路径
     */
    public static String createDoc(Map<String,Object> dataMap, String downloadType, String savePath){
        Configuration configure=null;
        configure=new Configuration();
        configure.setDefaultEncoding("utf-8");

        try {
            //加载需要装填的模板
            Template template=null;
            //设置模板装置方法和路径，FreeMarker支持多种模板装载方法。可以重servlet，classpath,数据库装载。
            //加载模板文件，放在testDoc下
            configure.setClassForTemplateLoading(Util.class,"/template/");
            //设置对象包装器
//            configure.setObjectWrapper(new DefaultObjectWrapper());
            //设置异常处理器
            configure.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
            //定义Template对象，注意模板类型名字与downloadType要一致
            String newFileName = (String) dataMap.get("caseSource")+"环保热线交办卡";
            template=configure.getTemplate(downloadType);
            //防止名称重复，每次创建的时候都重新创建一个以时间戳为名称的文件夹，将新生成的文件放进去
            String time = String.valueOf(new Date().getTime());
            savePath = savePath+time+"\\"+newFileName+".doc";
            File outFile=new File(savePath);
            if (!outFile.getParentFile().exists()) outFile.getParentFile().mkdirs();
            Writer out=null;
            out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
            template.process(dataMap, out);
            out.close();
            return savePath;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getImageStr(String imgFile){
        InputStream in=null;
        byte[] data=null;
        try {
            in=new FileInputStream(imgFile);
            data=new byte[in.available()];
            in.read(data);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder=new BASE64Encoder();
        return encoder.encode(data);
    }

  public static void main(String[] args) {
      Map<String, Object> dataMap=new HashMap<String, Object>();
      dataMap.put("time","2020-08-26");
      dataMap.put("reporter","甄亚新");
      dataMap.put("rphone","15101161025");
      dataMap.put("caseSource","微信");
      dataMap.put("caseCode","111111");
      dataMap.put("level","是");
      dataMap.put("recorder","甄亚新");
      dataMap.put("handoutTime","19:09");
      dataMap.put("backTime","19:10");
      dataMap.put("reportContent","测试");
      dataMap.put("receiveUser","admin");
      String doc = createDoc(dataMap, "new交办单模板.xml", "D:\\template\\");
      System.out.printf(doc);
  }

    /**
     * @return boolean
     * @Description 下载文件
     * @Param response，file
     **/
    public static boolean downloadFile(HttpServletResponse response, String fileName) {
        String fn =fileName.substring(fileName.lastIndexOf("\\")+1);
        try {
            fn = new String(fn.getBytes("UTF-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        File file = new File(fileName);
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + fn);
        OutputStream os = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            os = response.getOutputStream();
            //MS产本头部需要插入BOM
            //如果不写入这几个字节，会导致用Excel打开时，中文显示乱码
            os.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
            byte[] buffer = new byte[1024];
            int i = bufferedInputStream.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bufferedInputStream.read(buffer);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            //关闭流
            if (os != null) {
                try {
                    os.flush();
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
//            file.delete();
        }
        return false;
    }

}