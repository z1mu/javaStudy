package com.zimu.chapter12;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author : zimu
 * @Date: 2018/7/2 16:40
 * @description :   文件字节输入输出流
 */
public class Example12_4 {
    public static void main(String args[]){
        int b;
        byte tom[] = new byte[18];
        try {
            File file = new File("Example12_4.java");   //创建文件对象
            FileInputStream in = new FileInputStream(file); //创建字节输入流对象
            while ((b = in.read(tom, 0, 18))!=-1){  //循环输出读取的文件内容。
                String s = new String(tom, 0 , b);
                System.out.println(s);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
