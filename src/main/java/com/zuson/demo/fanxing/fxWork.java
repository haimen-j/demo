package com.zuson.demo.fanxing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class fxWork {

  public static void main(String[] args) {

      List<SE<Gender>> listSE = new ArrayList<>();
      SE<Gender> se = new SE<Gender>();
      se.setWorkOfYear(5);
      se.setId(1);
      se.setName("zs");
      se.setAge(18);
      listSE.add(se);
      Iterator<SE<Gender>> iterator = listSE.iterator();
      for (SE<Gender> ite = iterator.next(); iterator.hasNext();){
        System.out.println("aa"+ite);
      }
      List<PM<Gender>> listPM = new LinkedList<>();

  }
}
