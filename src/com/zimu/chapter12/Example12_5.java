package com.zimu.chapter12;

import java.io.FileOutputStream;

/**
 * @author : zimu
 * @Date: 2018/7/2 16:53
 * @description :
 */
public class Example12_5 {
    public static void main(String args[]){
        byte []b = "你好，进来忙吗？".getBytes();   //将字符串存储为二进制
        try {
            FileOutputStream out = new FileOutputStream("hello.txt");   //创建文件字节输出流
            out.write(b);   //写入文件
            out.write(b, 0, b.length);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
