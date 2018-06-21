package com.zimu.chapter4;

/**
 * @author : zimu
 * @2018/6/20 10:20
 * @description : 自动拆箱与装箱
 */
public class Example4_19 {
    public static void main(String args[]){
        Integer x = 100, y = 12;    //装箱：Integer x = new Integer(100), y = new Integer(12);
        Integer m = x+y;    //先拆箱再装箱：Integer m = new Integer(x.intValue() + y.intValue());
        int ok = m;     //拆箱
        System.out.print(ok);
    }
}
