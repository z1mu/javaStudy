package com.zimu.chapter9;

/**
 * @author : zimu
 * @Date: 2018/6/25 17:58
 * @description : 正则表达式和字符串的替换
 */
public class Example9_9 {
    public static void main(String args[]){
        String regex = "[1-9][0-9]*[.]?[0-9]*";
        String str1 =   "12r34a5";
        String str2 =   "123.45908";
        if(str1.matches(regex)){    //是否匹配到相应的字符串
            System.out.println(str1+"可以表示数字");
        }else {
            System.out.println(str1+"不可以表示数字");
            String  result  =   str1.replaceAll("\\D+", "");    //将匹配到的字符串进行替换
            System.out.println("剔除"+str1+"的非数字字符得到的字符串是：");
            System.out.println(result);
        }
        if(str2.matches(regex)){
            System.out.println(str2+"可以表示数字");
        }else {
            System.out.println(str2+"不可以表示数字");
            String  result  =   str2.replaceAll("\\D+ ", "");
            System.out.println("剔除"+str2+"的非数字字符得到的字符串是：");
            System.out.println(result);
        }
    }
}
