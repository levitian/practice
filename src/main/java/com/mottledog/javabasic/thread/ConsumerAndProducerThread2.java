package com.mottledog.javabasic.thread;

/**
 * synchronized修饰符
 * @author levitian
 *
 */
class Info2 {
	private String name = "xiaoming";
	private int age = 30;
	
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
		this.name = name;
		this.age =age;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//加同步锁
	public synchronized void get(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " " + this.getAge());
	}
}


class Producer2 implements Runnable{
	
	private Info2 info = null;
	
	public Producer2(Info2 info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		boolean flag = false;
		for(int i=0; i<25; i++){
			if(flag){
				this.info.set("xiaoming",20);
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


class Consumer2 implements Runnable{
	
	private Info2 info = null;
	
	public Consumer2(Info2 info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		for(int i=0; i<25; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.info.get();
		}
	}

}


public class ConsumerAndProducerThread2 {
	public static void main(String args[]){
		Info2 info = new Info2();
		Producer2 pro = new Producer2(info);
		Consumer2 con = new Consumer2(info);
		
		new Thread(pro).start();
		new Thread(con).start();
	}
}
