package com.mottledog.javabasic.thread;

/**
 * Thread和Runnable的区别 http://blog.csdn.net/michellehsiao/article/details/7639788
 * 多线程的优点：
 * 	一、多线程共享同一块内存空间和同一组系统资源
 * 	二、线程本身的数据通常都是只有微处理器的寄存器数据，以及供程序执行的堆栈。
 * 所以系统在产生一个线程或者线程的切换要比进程系统的负担小得多。
 * @author levitian
 *
 */
public class ThreadByExtendsThread extends Thread {
	
	private int count=10;
	
	public void run(){
		for(int i=0; i<10; i++){
			if(count >= 0){
				System.out.println("count: " + count--);
			}			
		}
	}
	//继承Thread类的线程没有对资源（count变量）进行共享
	public static void main(String args[]){
		ThreadByExtendsThread t1 = new ThreadByExtendsThread();
		t1.start();
		ThreadByExtendsThread t2 = new ThreadByExtendsThread();
		t2.start();
	}
}
