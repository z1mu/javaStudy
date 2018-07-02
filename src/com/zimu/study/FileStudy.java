package com.zimu.study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author : zimu
 * @Date: 2018/7/2 18:15
 * @description :   练习
 */
public class FileStudy {
    public static void main(String args[]){
        try {
            FileReader fileReader = new FileReader("hello.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = null;
            while ((s = bufferedReader.readLine())!=null){
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
