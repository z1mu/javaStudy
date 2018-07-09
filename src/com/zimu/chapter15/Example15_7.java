package com.zimu.chapter15;

/**
 * @author : zimu
 * @Date: 2018/7/9 16:49
 * @description :   唤醒线程
 */
public class Example15_7 {
    public static void main(String args[]){
        ClassRoom room = new ClassRoom();
        room.student.start();
        room.teacher.start();
    }
}
class ClassRoom implements Runnable{
    Thread teacher = new Thread(this);
    Thread student = new Thread(this);
    ClassRoom(){

        teacher.setName("雷老师");
        student.setName("张爱睡");
    }
    @Override
    public void run() {
        if (Thread.currentThread()==student){
            try {
                System.out.println(student.getName()+"正在睡觉！");
                Thread.sleep(1000*60*60);
            }catch (Exception e){
                System.out.println(student.getName()+"被老师叫醒了！");
            }
            System.out.println(student.getName()+"开始听课！");
        }else if (Thread.currentThread()==teacher){
            for (int i=0; i<3; i++){
                System.out.println("上课！");
                try {
                    Thread.sleep(500);
                }
                    catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            student.interrupt();
        }
    }
}
