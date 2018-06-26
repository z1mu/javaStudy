package com.zimu.chapter9;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @author : zimu
 * @Date: 2018/6/26 10:48
 * @description :   输出日历
 */
public class Example9_17 {
    public static void main(String args[]){
        Scanner reader  =   new Scanner(System.in);     //创建Scanner对象，读取输入字符
        System.out.println("输入年份回车确认:");
        int     year    =   reader.nextInt();   //定义年份
        System.out.println("输入月份回车确认:");
        int     month   =   reader.nextInt();   //定义月份
        CalendarBean  cb=   new CalendarBean();
        cb.setMonth(month);
        cb.setYear(year);
        String[]    a   =   cb.getCalendar();
        System.out.println("\t"+year+"年"+month+"月 日 历");
        char[] str = "日一二三四五六".toCharArray();   //创建char型数组
        for (char c:str){   //循环输出数组
            System.out.printf(" %3c", c);
        }
        for (int i=0; i<a.length; i++){
            if(i%7==0)      //输出七列后换行
                System.out.println("");
            System.out.printf(" %4s", a[i]);
        }

    }
}
class CalendarBean{
    String[]    day;
    int year = 2008, month = 0;
    public void setYear(int year){
        this.year   =   year;
    }
    public void setMonth(int month){
        this.month  =   month;
    }
    public String[] getCalendar(){
        String[]    a   =   new String[42];     //创建一个六行七列的数组
        Calendar    calendar    =   Calendar.getInstance(); // 创建calendar对象
        calendar.set(year, month-1, 1); //设置时间中的值
        int weekday =   calendar.get(Calendar.DAY_OF_WEEK)-1;   //返回星期几的值
        int day =   0;
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            day =   31;
        if(month==4||month==6||month==9||month==11)
            day =   30;
        if(month==2){
            if(((year%4==0)&&(year%100!=0))||(year%400==0))
                day =   29;
            else
                day =   28;
        }
        for (int i=0; i<weekday; i++){
            a[i] = " ";
        }
        for (int i=weekday, n=1; i<weekday+day; i++){
            a[i] = String.valueOf(n);   //转换为字符串
            n++;
        }
        for (int i=weekday+day; i<a.length; i++)
            a[i]=" ";
        return a;
    }
}