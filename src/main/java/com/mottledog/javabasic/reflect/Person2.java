package com.mottledog.javabasic.reflect;


class Person2 implements China{

	private String sex;
	
	
	public Person2() {
		super();
	}

	public Person2(String sex) {
		super();
		this.sex = sex;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public void sayChina() {
		System.out.println("hello, china!");
	}

	@Override
	public void sayHello(String name, int age) {
		System.out.println(name + " " + age);
	}
	
	public static void main(String[] args){
		
	}
}

class Hello4{
	public static void main(String[] args){
		Class<?> demo = null;
		try {
			demo = Class.forName("com.mottledog.javabasic.reflect.Person2");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Class<?> intes[] = demo.getInterfaces();
		for(Class<?> i : intes){
			System.out.println("实现的接口：" + i.getName());
		}
	}
}