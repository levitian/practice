package com.mottledog.javabasic.thread;

/**
 * Object类的等待和唤醒
 * @author levitian
 *
 */
class Info3 {
	private String name = "xiaoming";
	private int age = 30;
	
	private boolean flag = false;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//加同步锁
	public synchronized void set(String name, int age){
		if(!flag){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.age =age;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = false;
		super.notify();
	}
	//加同步锁
	public synchronized void get(){
		if(flag){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " " + this.getAge());
		flag = true;
		super.notify();
	}
}


class Producer3 implements Runnable{
	
	private Info3 info = null;
	
	public Producer3(Info3 info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		boolean flag = false;
		for(int i=0; i<35; i++){
			if(flag){
				this.info.set("xiaoming",30);
/*				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
*/				flag = false;
			}else{
				this.info.set("dawang",99);
/*				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				flag = true;
			}
		}
		
	}

}


class Consumer3 implements Runnable{
	
	private Info3 info = null;
	
	public Consumer3(Info3 info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		for(int i=0; i<35; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.info.get();
		}
	}

}


public class ConsumerAndProducerThread3 {
	public static void main(String args[]){
		Info3 info = new Info3();
		Producer3 pro = new Producer3(info);
		Consumer3 con = new Consumer3(info);
		
		new Thread(pro).start();
		new Thread(con).start();
	}
}
