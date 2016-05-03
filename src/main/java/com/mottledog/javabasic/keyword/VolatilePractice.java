package com.mottledog.javabasic.keyword;

/**
 * volatile修饰变量
 * 在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。
 * 而且，当成员变量发生变化时，强迫线程将变化值回写到共享内存。
 * 这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
 * 
 * Java 理论与实践: 正确使用 Volatile 变量
 * http://www.ibm.com/developerworks/cn/java/j-jtp06197.html
 * @author tianl
 *
 */

//TODO 尚未完全理解
public class VolatilePractice {

    public static int count = 0;
 
    public static void inc() {
 
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
 
        count++;
    }
 
    public static void main(String[] args) {
 
        //同时启动1000个线程，去进行i++计算，看看实际结果
 
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                	VolatilePractice.inc();
                }
            }).start();
        }
 
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + VolatilePractice.count);
    }
}

class VolatilePractice1{
	 public volatile static int count = 0;
	 
	    public static void inc() {
	 
	        //这里延迟1毫秒，使得结果明显
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	        }
	 
	        count++;
	    }
	 
	    public static void main(String[] args) {
	 
	        //同时启动1000个线程，去进行i++计算，看看实际结果
	 
	        for (int i = 0; i < 1000; i++) {
	            new Thread(new Runnable() {
	                @Override
	                public void run() {
	                	VolatilePractice1.inc();
	                }
	            }).start();
	        }
	 
	        //这里每次运行的值都有可能不同,可能为1000
	        System.out.println("运行结果:Counter.count=" + VolatilePractice1.count);
	    }
}

class VolatilePractice2{
	 public static  int count = 0;
	 
	    public static  void inc() {
	 
	        //这里延迟1毫秒，使得结果明显
	        try {
	            Thread.sleep(1);
	        } catch (InterruptedException e) {
	        }
	 
	        count++;
	    }
	 
	    public static void main(String[] args) {
	 
	        //同时启动1000个线程，去进行i++计算，看看实际结果
	 
	        for (int i = 0; i < 1000; i++) {
	            new Thread(new Runnable() {
	                @Override
	                public void run() {
	                	VolatilePractice2.inc();
	                }
	            }).start();
	        }
	 
	        //这里每次运行的值都有可能不同,可能为1000
	        System.out.println("运行结果:Counter.count=" + VolatilePractice2.count);
	    }
}
