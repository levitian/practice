package com.mottledog.javabasic.thread;

/**
 * 同步就是在统一时间段中只有有一个线程运行，其他的线程必须等到这个线程结束之后才能继续执行。
 * @author levitian
 *
 */
public class TicketSystemBySynchronizedObject implements Runnable {
	//剩余票数
	private int count = 5;
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			//同步代码块
			//当前对象this作为同步对象
			synchronized (this) {
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
	}
	
	//同步代码块确保了余票的准确性
	public static void main(String args[]){
		TicketSystemBySynchronizedObject t = new TicketSystemBySynchronizedObject();
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
