package com.zuson.demo.controller;




import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.rmi.CORBA.Util;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry
 * @Title: WordUtil
 * @Description: Word工具类
 * @date 219/10/6 9:09
 */
public class wordDynamicAssignment {

    public static  String createWord1(Map dataMap, String templateName, String filePath, String fileName){
        String    fileOnlyName=null;
        try {
            //创建配置实例
            Configuration configuration = new Configuration();

            //设置编码
            configuration.setDefaultEncoding("UTF-8");

            //ftl模板文件统一放至 template 包下面
            configuration.setClassForTemplateLoading(Util.class, "/template/");

            //获取模板
            Template template = configuration.getTemplate(templateName,"UTF-8");
      // 重命名

          // 输出文件
          File outFile = new File(filePath+fileName);

            //如果输出目标文件夹不存在，则创建
            if (!outFile.getParentFile().exists()   ){
                outFile.getParentFile().mkdirs();
            }

            //将模板和数据模型合并生成文件
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            //生成文件
            template.process(dataMap, out);
            //关闭流
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileOnlyName;
    }

  public static void main(String[] args) {
        Map map = new HashMap();
        map.put("time","2020-08-26");
        map.put("person","甄亚新");
        map.put("phone","15101161025");
    createWord1(map, "12369环保热线交办卡1111.ftl", "D:\\template", "测试1");
  }
}
