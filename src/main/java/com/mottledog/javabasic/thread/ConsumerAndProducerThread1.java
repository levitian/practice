package com.mottledog.javabasic.thread;

class Info {
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
}

class Producer implements Runnable{
	
	private Info info = null;
	
	public Producer(Info info) {
		super();
		this.info = info;
	}

	@Override
	public void run() {
		boolean flag = false;
		for(int i=0; i<25; i++){
			if(flag){
				this.info.setName("xiaoming");
				this.info.setAge(20);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = false;
			}else{
				this.info.setName("dawang");
				this.info.setAge(89);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				flag = true;
			}
		}
		
	}

}



class Consumer implements Runnable{
	
	private Info info = null;
	
	public Consumer(Info info) {
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
			System.out.println(this.info.getName() + " " + this.info.getAge());
		}
	}

}



public class ConsumerAndProducerThread1 {
	public static void main(String args[]){
		Info info = new Info();
		Producer pro = new Producer(info);
		Consumer con = new Consumer(info);
		
		new Thread(pro).start();
		new Thread(con).start();
	}
}
