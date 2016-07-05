package com.mottledog.javabasic.thread;

public class ThreadByImplementsRunnable implements Runnable {
	
	private int count = 10;
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			if(count > 0){
				System.out.println(Thread.currentThread().getName() +"　:" + count--);
			}
		}
	}
	
	//实现Runnable的多个线程共用了一个数据源
	//main方法其实也是一个线程
	public static void main(String args[]){
		ThreadByImplementsRunnable t1 = new ThreadByImplementsRunnable();
		//t1.run(); 直接调用run方法，则是由main线程进行了调用
		
		Thread t = new Thread(t1,"number 0");
		System.out.println("before thread t start:" + t.isAlive());
		t.start();
		System.out.println("end thread t start:" + t.isAlive());
		
		

		new Thread(t1,"number 1").start();
		new Thread(t1,"number 2").start();
		//如果我们不指定线程名字的话，系统自动提供名字
		new Thread(t1).start();
		
		
	}
}
