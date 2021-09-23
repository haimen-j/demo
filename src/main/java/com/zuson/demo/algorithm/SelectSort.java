package com.zuson.demo.algorithm;

/**
 * 选择排序：
 * 值进行对比，记录下标
 */
public class SelectSort {


  public static void main(String[] args) {
    int [] intArr = {5,6,1,2,3,4,8,7,9};
    int minIndex = 0;
    for (int i = 1; i < intArr.length; i++) {
        if (intArr[minIndex]>intArr[i]){
            minIndex = i;
        }
    }
    int temp = intArr[0];
    intArr[0] = intArr[minIndex];
    intArr[minIndex] = temp;
    System.out.println("minIndex:"+minIndex);
    for (int i = 0; i < intArr.length; i++) {
      System.out.print(intArr[i]+" ");
    }
  }
}
