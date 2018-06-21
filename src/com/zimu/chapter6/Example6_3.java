package com.zimu.chapter6;

/**
 * @author : zimu
 * @2018/6/21 9:58
 * @description :   和接口有关的匿名类
 */
interface Cubic{
    double  getCubic(double x);
}
class A{
    void f(Cubic cubic){
        double result = cubic.getCubic(3);
        System.out.print("result="+result);
    }
}

public class Example6_3 {
    public static void main(String args[]){
        Cubic cubic = new Cubic() {
            @Override
            public double getCubic(double x) {
                return x*x*x;
            }
        };
        double m = cubic.getCubic(5);   //接口回调
        System.out.print("m="+m);
        A a = new A();
        a.f(new Cubic() {
            @Override
            public double getCubic(double x) {
                return x*x*x;
            }
        });
    }
}
