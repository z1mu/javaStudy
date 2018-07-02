package com.zimu.chapter12;

import java.io.File;

/**
 * @author : zimu
 * @Date: 2018/7/2 16:28
 * @description :   执行可执行文件
 */
public class Example12_3 {
    public static void main(String args[]){
        try {
            Runtime ce = Runtime.getRuntime();  //获得当前运行环境
            File    file = new File("C:\\windows\\system32", "cmd.exe");
            ce.exec(file.getAbsolutePath());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
