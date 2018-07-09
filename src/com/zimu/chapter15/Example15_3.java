package com.zimu.chapter15;

/**
 * @author : zimu
 * @Date: 2018/7/9 16:18
 * @description :   线程利用
 */
public class Example15_3 {
    public static void main(String args[]){
        Bank bank = new Bank();
        bank.setMoney(300);
        Thread threadOne = new Thread(bank);
        Thread threadTwo = new Thread(bank);
        threadOne.setName("One");
        threadTwo.setName("Two");
        threadOne.start();
        threadTwo.start();
    }
}

class Bank implements Runnable{
    private int number = 0;
    public void setMoney(int money){
        number = money;
    }
    @Override
    public void run() {
        while (true){
            if(Thread.currentThread().getName().equals("One")){
                if (number<=160){
                    System.out.println(Thread.currentThread().getName()+"进入死亡状态！");
                    return;
                }
                number = number+10;
                System.out.println("我是"+Thread.currentThread().getName()+"现在 number="+number);
            }
            if(Thread.currentThread().getName().equals("Two")){
                if (number<=0){
                    System.out.println(Thread.currentThread().getName()+"进入死亡状态！");
                    return;
                }
                number = number-10;
                System.out.println("我是"+Thread.currentThread().getName()+"现在 number="+number);
            }
            try {
                Thread.sleep(800);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
