package com.mottledog.javabasic.thread;

/**
 * 实现了Runnable接口的线程类
 * 
 * Thread与Runnable的区别：
 * 	1.Runnable适合于多个相同程序代码线程去处理统一资源的情况，把虚拟的cpu（线程）同程序的代码，数据有效分离，
 * 较好体现面向对象的编程思想。
 * 	2.Runnable可以避免由于java的单继承机制带来的局限。在可以继承其他类的同时，还能实现多线程的功能。
 * 	3.Runnable能增加程序的健壮性。代码能够被多个线程共享，代码和数据独立。
 * @author levitian
 *
 */
public class HelloImplementsRunnable implements Runnable{

	private String name;
	
	public HelloImplementsRunnable() {
		super();
	}

	public HelloImplementsRunnable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++){
			System.out.println(name + "运行 " + i);
		}
	}

	public static void main(String args[]){
		HelloImplementsRunnable h1 = new HelloImplementsRunnable("线程A");
		Thread d1 = new Thread(h1);
		HelloImplementsRunnable h2 = new HelloImplementsRunnable("线程B");
		Thread d2 = new Thread(h2);
		d1.start();
		d2.start();
		
	}
}
