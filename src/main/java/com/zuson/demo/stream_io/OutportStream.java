package com.zuson.demo.stream_io;

import java.io.*;

public class OutportStream {

  public static void main(String[] args) {

      //读数据
      InputStream inputStream = null;
      StringBuffer sb = new StringBuffer();
      try {
          inputStream = new FileInputStream("src/aaa.txt");
          int read = 0;
          byte [] bf = new byte[1024];
          while ((read=inputStream.read(bf))!=-1){
              String s = new String(bf, 0, read);
              sb.append(s);
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }


      File file = new File("src/bbb.txt");
      OutputStream outputStream = null;
      try {
          outputStream = new FileOutputStream(file);
          outputStream.write(sb.toString().getBytes());
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }finally{
          try {
              outputStream.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
}
