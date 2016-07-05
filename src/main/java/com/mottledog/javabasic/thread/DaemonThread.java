package com.mottledog.javabasic.thread;

public class DaemonThread implements Runnable{

	@Override
	public void run() {
		while(true){
			System.out.println( Thread.currentThread().getName() +" is running");
		}
	}

	public static void main(String args[]){
		System.out.println("begin----------");
		DaemonThread dt = new DaemonThread();
		Thread t = new Thread(dt,"thread-daemon");
		t.setDaemon(true);
		t.start();
		System.out.println("end----------");
	}
}
