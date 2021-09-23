package com.zuson.demo.stream_io;

import java.io.*;

public class StreamDemo {

  public static void main(String[] args) {
//      File file = new File("aaa.txt");
      InputStream file = null;
      try {
          file = new FileInputStream("src/aaa.txt");
          byte [] buffer = new byte[2048];
          int read = 0;
          while ((read = file.read(buffer,5,5))!=-1){
            System.out.println(new String(buffer,5,read));
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }finally{
          try {
              file.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
}
