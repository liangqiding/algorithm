package com.algorithm.demo.huaWei;

/**
 * date: 2021-01-25 10:28
 * description
 *
 * @author qiDing
 */
import java.util.Scanner;

/**
 * 题目描述
 * 问题描述：有4个线程和1个公共的字符数组。
 * 线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，
 * 线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定
 */
public class 线程 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            Object a = new Object();
            Object b = new Object();
            Object c = new Object();
            Object d = new Object();
            Thread thread1 = new Thread(new ThreadPrintAbcd("A",a,b,num));
            Thread thread2 = new Thread(new ThreadPrintAbcd("B",b,c,num));
            Thread thread3 = new Thread(new ThreadPrintAbcd("C",c,d,num));
            Thread thread4 = new Thread(new ThreadPrintAbcd("D",d,a,num));

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
        }
    }
}
class ThreadPrintAbcd implements Runnable{
    private static int newIndex=0;
    private static int runIndex=0;
    private boolean isFirstRun=true;
    private final Object self;
    private final Object next;
    private final String name;
    private final int id;
    private int num;

    public ThreadPrintAbcd(String name,Object self,Object next,int num){
        id = newIndex++;
        this.name = name;
        this.self = self;
        this.next = next;
        this.num = num;
    }
    @Override
    public void run() {
        while (num > 0){
            synchronized(self){
                if(id > runIndex){
                    try {
                        // 等待别的线程放锁 每个线程都会初始化时执行一次
                        self.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(name);
                if(isFirstRun){
                    runIndex ++;
                    isFirstRun=false;
                }
                synchronized (next) {
                    next.notify();
                }
                num--;
                if(num >0){
                    try {
                        // 等待别的线程放锁
                        self.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

