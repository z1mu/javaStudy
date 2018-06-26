package com.zimu.chapter9;

import java.util.StringTokenizer;

/**
 * @author : zimu
 * @Date: 2018/6/26 09:47
 * @description :   StringTokenizer类
 */
public class Example9_13 {
    public static void main(String args[]){
        String  s   =   "we are stud,ents";
        StringTokenizer fenxi   =   new StringTokenizer(s, " ,");   //用空格和逗号的任意组合作为分隔标记，逗号和空格可以放在一起
        int number  =   fenxi.countTokens();    //获得分隔后的单词数量
        while (fenxi.hasMoreTokens()){      //使用StringTokenizer类中的hasMoreToken()方法，只要字符串中还有语言符号，就返回true
            String  str =   fenxi.nextToken();  //获得分隔后的下一个单词
            System.out.println(str);
            System.out.println("还剩"+fenxi.countTokens()+"个单词");     //每循环一次countTokens自动减一
        }
        System.out.println("s共有单词："+number+"个");
    }
}
