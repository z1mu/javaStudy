package com.zimu.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : zimu
 * @2018/6/20 19:25
 * @description :   执行系统命令
 */
public class cmd {
    public static void main(String agrs[]){
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec("ipconfig");
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
