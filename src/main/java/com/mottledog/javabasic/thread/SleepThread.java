package com.mottledog.javabasic.thread;

public class SleepThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<3; i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " + i + " " + System.currentTimeMillis());
		}
	}

	
	public static void main(String args[]){
		SleepThread st = new SleepThread();
		Thread t = new Thread(st,"xianc");
		t.start();
	}
}
