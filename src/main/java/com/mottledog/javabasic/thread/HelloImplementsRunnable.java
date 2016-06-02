package com.mottledog.javabasic.thread;

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
