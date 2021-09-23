package com.zuson.demo.stream_io;

import java.io.*;

public class ImgCopy {

  public static void main(String[] args) {
    File file = new File("src/1.jpg");
    //读取图片
      InputStream inputStream = null;
      BufferedInputStream bufferedInputStream = null;
      OutputStream outputStream = null;
      BufferedOutputStream bufferedOutputStream = null;
      try {
          inputStream = new FileInputStream(file);
          bufferedInputStream = new BufferedInputStream(inputStream);

          outputStream = new FileOutputStream(new File("src/2.jpg"));
          bufferedOutputStream = new BufferedOutputStream(outputStream);
          int len = 0;
          while ((len = bufferedInputStream.read())!=-1){
              bufferedOutputStream.write(len);
          }
          bufferedOutputStream.flush();
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }finally{
          try {
              bufferedOutputStream.close();
          } catch (IOException e) {
              e.printStackTrace();
          }

          try {
              outputStream.close();
          } catch (IOException e) {
              e.printStackTrace();
          }

          try {
              bufferedInputStream.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
          try {
              inputStream.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }

  }
}
