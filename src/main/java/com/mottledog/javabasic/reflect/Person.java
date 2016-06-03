package com.mottledog.javabasic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 *  实例化对象
 * @author tianl
 *
 */
class Person {
	String name;
	int age;
	
	public Person() {
		super();
	}

	public Person(String name) {
		this.name = name;
	}
	
	public Person(Integer age) {
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public static void main(String args[]){
		
	}
	
}

/**
 *  通过无参构造函数实例化对象
 *  将无参构造函数注释后，只定义有参构造函数，
 *  会抛出异常 java.lang.InstantiationException: com.mottledog.javabasic.reflect.Person
 * @author tianl
 *
 */
class Hello2{
	public static void main(String args[]){
		Class<?> demo = null;
		try {
			demo = Class.forName("com.mottledog.javabasic.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Person per = null;
		try {
			per = (Person)demo.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		per.setAge(20);
		per.setName("qin");
		
		System.out.println(per.toString());
	}
}

/**
 * 通过有参构造函数实例化对象
 * @author tianl
 *
 */
class Hello3{
	public static void main(String[] args){
		Class<?> demo=null;
		try {
			demo = Class.forName("com.mottledog.javabasic.reflect.Person");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Person per1 = null;
		Person per2 = null;
		Person per3 = null;
		Person per4 = null;
		
		//TODO api未声明返回的构造函数数组是有序的，参考 http://bbs.csdn.net/topics/390183924
		Constructor<?> cons[] = demo.getConstructors();
		
    /*    Constructor cons0 = demo.getConstructor();
        Constructor cons1 = demo.getConstructor(String.class);
        Constructor cons2 = demo.getConstructor(int.class);
        Constructor cons3 = demo.getConstructor(String.class,int.class);*/
		Constructor<?> cons2[] = demo.getDeclaredConstructors();
		System.out.println(cons2.length);
		
		Class<?> ts[] = cons[2].getParameterTypes();
		for(Class<?> t : ts){
			System.out.print(t.getName() + " ");
		}
		System.out.println();
		try {
			per1 = (Person) cons[0].newInstance();
			per2 = (Person) cons[1].newInstance("levi",22);
			per3 = (Person) cons[2].newInstance(121);
			per4 = (Person) cons[3].newInstance("tianl");
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(per1);
		System.out.println(per2);
		System.out.println(per3);
		System.out.println(per4);
	}
}

