package com.zimu.chapter15;

/**
 * @author : zimu
 * @Date: 2018/7/9 15:53
 * @description :   线程
 */
public class Example15_1 {
    public static void main(String args[]){
        SpeakHello speakHello = new SpeakHello();
        SpeakNiHao speakNiHao = new SpeakNiHao();
        speakHello.start();
        speakNiHao.start();
        for (int i=0; i<15; i++){
            System.out.println("大家好"+i+" ");
        }
    }
}

class SpeakHello extends Thread{
    @Override
    public void run() {
        for (int i=0 ; i<20; i++){
            System.out.println("hello"+i+"  ");
        }
    }
}
class SpeakNiHao extends Thread{
    @Override
    public void run() {
        for (int i=0; i<20; i++){
            System.out.println("你好"+i+" ");
        }
    }
}
