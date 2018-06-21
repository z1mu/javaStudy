package com.zimu.chapter5;

/**
 * @author : zimu
 * @2018/6/20 15:30
 * @description :  abstract类
 */
abstract class A{
    abstract int sum(int x, int y);
    int sub(int x, int y){
        return x-y;
    }
}
class B extends A{
    int sum(int x, int y){
        return x+y;
    }
}
public class Example5_11 {
    public static void main(String args[]){
        B b = new B();
        int sum = b.sum(2,1);
        int sub = b.sub(4,2);
        System.out.print(sum+"\n");
        System.out.print(sub);
    }
}
