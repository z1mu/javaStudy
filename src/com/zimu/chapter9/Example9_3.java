package com.zimu.chapter9;

import java.util.Arrays;

/**
 * @author : zimu
 * @Date: 2018/6/25 10:50
 * @description : Arrays.sort()的使用
 */
public class Example9_3 {
    public static void main(String args[]){
        String[] a = {"boy", "apple", "Applet", "girl", "Hat"};
        String[] b = Arrays.copyOf(a, a.length);    //把数组a的值赋值给数组b
        System.out.println("排列a:");
        SortString.sort(a);
        for (String s:a){   //循环输出a中的值
            System.out.print(" "+s);
        }
        System.out.println();
        System.out.println("数组b:");
        Arrays.sort(b);
        for (String s:b){
            System.out.print(" "+s);
        }
    }
}
class SortString{
        public static void sort(String a[]){
            for (int i=0; i<a.length-1; i++){
                for (int j=i+1; j<a.length; j++){
                    if(a[j].compareTo(a[i])<0){
                        String temp = a[i];
                        a[i]=a[j];
                        a[j]=temp;
                    }
                }
            }
        }
}
