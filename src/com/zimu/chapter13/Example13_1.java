package com.zimu.chapter13;

/**
 * @author : zimu
 * @Date: 2018/6/26 16:24
 * @description :   泛型
 */

class Cone<E>{
    double  height;
    E       bottom;     //用泛型类E声明对象bottom
    Cone(E b){
        bottom  =   b;
    }
    public void setHeight(double h){
        height  =   h;
    }
    public double computerVolume(){
        String  s   =   bottom.toString();      //泛型变量只能调用从Object类继承的或重写的方法
        double  area=   Double.parseDouble(s);
        return 1.0/3.0*area*height;
    }
}
class Rect{
    double  SideA,  SideB, area;
    Rect(double a, double b){
        SideA   =   a;
        SideB   =   b;
    }
    public String   toString(){
        area    =   SideA*SideB;
        return ""+area;
    }
}

class Circle{
    double  area,   radius;
    public Circle(double r){
        radius  =   r;
    }
    public String   toString(){
        area    =   radius*radius*Math.PI;
        return ""+area;
    }
}
public class Example13_1 {
    public static void main(String args[]){
        Circle  circle  =   new Circle(10);
        Cone<Circle>    cone    =   new Cone<Circle>(circle);
        cone.setHeight(16);
        System.out.println(cone.computerVolume());
        Rect    rect    =   new Rect(15, 23);
        Cone<Rect>      cone1   =   new Cone<Rect>(rect);
        cone1.setHeight(98);
        System.out.println(cone1.computerVolume());
    }
}
