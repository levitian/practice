
package com.mottledog.javabasic.thread;

/**
 * 线程的优先级：不要误以为优先级越高就先执行。谁先执行还是取决于谁先去的CPU的资源
 * 主线程的优先级是5
 * @author levitian
 *
 */
public class PriorityThread implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<5; i++){
			System.out.println(Thread.currentThread().getName() + " is running on " + i);
		}
	}
	
	public static void main(String args[]){
		Thread t1 = new Thread(new PriorityThread(),"A");
		Thread t2 = new Thread(new PriorityThread(),"B");
		Thread t3 = new Thread(new PriorityThread(),"C");
		t1.setPriority(8);
		t2.setPriority(1);
		t1.setPriority(4);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
