package com.mottledog.javabasic.thread;

/**
 * 
 * @author levitian
 *
 */
public class JoinThread implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<3; i++){
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
	
	public static void main(String args[]){
		JoinThread jt = new JoinThread();
		Thread demo = new Thread(jt,"xiancheng");
		demo.start();
		for(int i=0; i<50; i++){
			if(i>20){
				try {
					//调用join方法后，会先执行当前线程，主线程被停止执行，执行完毕当前线程后，继续主线程。
					demo.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("main 线程执行--->" + i);
		}
		
	}
	
}
