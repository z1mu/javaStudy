package com.zimu.chapter5;

/**
 * @author : zimu
 * @2018/6/21 8:47
 * @description :接口回调
 */
interface ShowMessage{
    void showLogo(String s);
}

class TV implements ShowMessage{
    public void showLogo(String s){
        System.out.print(s);
    }
}

class PC implements ShowMessage{
    public void showLogo(String s){
        System.out.print(s);
    }
}
public class Example5_16 {
    public static void main(String agrs[]){
        ShowMessage sm;     //声明接口变量
        sm      =   new TV();   //接口变量中存放对象的引用
        sm.showLogo("长城电视机");   //接口回调
        sm      =   new PC();
        sm.showLogo("DELL Computer.");
        TV  tv  =   new TV();
        tv.showLogo("三星电视机");
    }
}
