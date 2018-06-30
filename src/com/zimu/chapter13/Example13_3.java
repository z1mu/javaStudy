package com.zimu.chapter13;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author : zimu
 * @Date: 2018/6/30 08:55
 * @description :   迭代器（Iterator）遍历数组和for循环遍历数组的比较
 */
public class Example13_3 {
    public static void main(String args[]){
        LinkedList<String> list = new LinkedList<String>();  //定义泛型列表
        for (int i=0; i<=60096; i++){   //创建数组
            list.add("speed "+i);
        }
        Iterator<String> iter = list.iterator();        //创建iterator（迭代器）对象
        long starttime = System.currentTimeMillis();    //获取系统当前时间，单位：毫秒
        while (iter.hasNext()){     //通过迭代器遍历数组
            String te = iter.next();
        }
        long endTime = System.currentTimeMillis();
        long result = endTime - starttime;
        System.out.println("使用迭代器遍历集合所用时间："+result+"毫秒");
        starttime = System.currentTimeMillis();
        for (int i=0; i<list.size(); i++){  //for循环遍历数组
            String te = list.get(i);
        }
        endTime = System.currentTimeMillis();
        result = endTime - starttime;
        System.out.println("使用get方法遍历集合所用时间："+result+"毫秒");
    }
}
