package com.mottledog.javabasic.thread;

/**
 * java多线程总结 http://www.cnblogs.com/rollenholt/archive/2011/08/28/2156357.html
 * 
 * 继承Thread的线程类
 * @author levitian
 *
 */
public class HelloExtendsThread extends Thread {

	private String name;

	public HelloExtendsThread() {
		super();
	}

	public HelloExtendsThread(String name) {
		super();
		this.name = name;
	}

	public void run(){
		for(int i=0; i<5; i++){
			System.out.println(name +"运行 " + i);
		}
	}
	
	/**
	 * java中thread的start()和run()的区别  http://blog.csdn.net/wangyangkobe/article/details/5839182
	 * @param args
	 * 
	 * start()方法用来启动线程，但并不等待run方法体代码执行完毕，而是直接继续执行下面的代码
	 * run()方法当做普通方法的方式被调用，顺序执行，run方法体执行完后才能继续执行下面的代码。
	 * 
	 * Java线程中run和start方法的区别 http://www.cnblogs.com/linjiqin/archive/2011/04/10/2011272.html
	 * Thread类中run()和start()方法的区别如下：
		run()方法:在本线程内调用该Runnable对象的run()方法，可以重复多次调用；
		start()方法:启动一个线程，调用该Runnable对象的run()方法，不能多次启动一个线程；
	 * 
	 */
	public static void main(String[] args){
		HelloExtendsThread het1 = new HelloExtendsThread("A");
		HelloExtendsThread het2 = new HelloExtendsThread("B");
	/*	het1.run();
		het2.run();*/
		het1.start();
		het2.start();
	}
}
