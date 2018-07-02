package com.zimu.chapter12;

import java.io.*;

/**
 * @author : zimu
 * @Date: 2018/7/2 17:39
 * @description :   BufferedReader and BufferedWrite
 */
public class Example12_7 {
    public static void main(String args[]){
        File file = new File("Student.txt");
        String content[] = {"天气预报:", "北京晴", "上海多云,有小雨" , "大连晴，有时多云"};
        try {
            FileWriter outOne = new FileWriter(file);   //创建文件写对象
            BufferedWriter outTwo = new BufferedWriter(outOne); //创建BufferedWriter对象
            for (String str:content){
                outTwo.write(str);
                outTwo.newLine();
            }
            outTwo.close();
            outOne.close();
            FileReader inOne = new FileReader(file);
            BufferedReader inTwo = new BufferedReader(inOne);
            String s = null;
            while ((s = inTwo.readLine())!=null){
                System.out.println(s);
            }
            inOne.close();
            inTwo.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
