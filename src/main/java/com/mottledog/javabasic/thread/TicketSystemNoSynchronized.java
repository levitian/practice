package com.mottledog.javabasic.thread;

public class TicketSystemNoSynchronized implements Runnable{
	
	//剩余票数
	private int count = 5;
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			if(count > 0){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(count--);
			}
		}
	}
	
	//剩余票数有可能变为负值
	public static void main(String args[]){
		TicketSystemNoSynchronized t = new TicketSystemNoSynchronized();
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
