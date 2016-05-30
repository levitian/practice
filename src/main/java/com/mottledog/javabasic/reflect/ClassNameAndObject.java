package com.mottledog.javabasic.reflect;

/**
 * java反射详解: http://www.cnblogs.com/rollenholt/archive/2011/09/02/2163758.html
 * 
 * @author tianl
 *
 */
public class ClassNameAndObject {
	public static void main(String args[]){
		//实例化class类对象
		Class<?> demo1 = null;
		Class<?> demo2 = null;
		Class<?> demo3 = null;
		try {
			//一般采用这种方式
			demo1 = Class.forName("com.mottledog.javabasic.reflect.Demo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		demo2 = new Demo().getClass();
		demo3 = Demo.class;
		System.out.println("类名称  " + demo1.getName());
		System.out.println("类名称  " + demo2.getName());
		System.out.println("类名称  " + demo3.getName());
	}
}

class Demo{
	
}

class Hello{
	public static void main(String args[]){
		//通过一个对象获取完整的包名和类名
		Demo demo = new Demo();
		System.out.println("demo class name: " + demo.getClass().getName());
		System.out.println("demo class simplename: " + demo.getClass().getSimpleName());
	}
	
}