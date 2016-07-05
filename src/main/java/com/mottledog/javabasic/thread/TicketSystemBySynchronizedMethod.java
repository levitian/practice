package com.mottledog.javabasic.thread;

public class TicketSystemBySynchronizedMethod implements Runnable {

	//剩余票数
	private int count = 5;
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			sale();
		}
	}
	
	public synchronized void sale(){
		if(count > 0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(count--);
		}		
	}

	//同步方法确保了余票的准确性
	public static void main(String args[]){
		TicketSystemBySynchronizedMethod t = new TicketSystemBySynchronizedMethod();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
