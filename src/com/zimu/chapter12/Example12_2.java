package com.zimu.chapter12;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author : zimu
 * @Date: 2018/7/2 16:16
 * @description :   目录
 */
public class Example12_2 {
    public static void main(String args[]){
        File dir = new File(".");
        FileAccept fileAccept = new FileAccept();
        fileAccept.setExtendName("java");   //设置文件扩展名为java
        String fileName[] = dir.list(fileAccept);   //获取当前路径下指定扩展名的文件列表
        for (String name:fileName){
            System.out.println(name);
        }
    }
}
class FileAccept implements FilenameFilter{
    private String extendName;
    public void setExtendName(String s){
        extendName = "."+s;
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extendName);
    }
}
