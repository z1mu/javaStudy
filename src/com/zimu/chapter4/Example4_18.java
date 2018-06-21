package com.zimu.chapter4;

/**
 * @author : zimu
 * @2018/6/20 10:09
 * @description : character类
 */
public class Example4_18 {
    public static void main(String agrs[]){
        char a[] = {'a', 'b', 'c', 'D', 'E', 'F'};
        for (int i=0; i<a.length; i++){
            if (Character.isLowerCase(a[i])){
                a[i] = Character.toUpperCase(a[i]);     //小写转大写
            }
            else if (Character.isUpperCase(a[i])){
                a[i] = Character.toLowerCase(a[i]);     //大写转小写
            }
        }
        for (int i=0; i<a.length; i++){
            System.out.print(" "+a[i]);
        }
    }
}
