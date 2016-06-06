package com.mottledog.javabasic.keyword;


/*
 * Java中final、finally和finalize的区别（转）
	final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。
	finally 是异常处理语句结构的一部分，表示总是执行。
	finalize 是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等
	
	final—修饰符（关键字）如果一个类被声明为final，意味着它不能再派生出新的子类，不能作为父类被继承。因此一个类不能既被声明为 abstract的，
又被声明为final的。将变量或方法声明为final，可以保证它们在使用中不被改变。被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取，
不可修改。被声明为final的方法也同样只能使用，不能重载。
	finally—在异常处理时提供 finally 块来执行任何清除操作。如果抛出一个异常，那么相匹配的 catch 子句就会执行，然后控制就会进入 finally 块（如果有的话）。
	finalize—方法名。Java 技术允许使用 finalize() 方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在确
定这个对象没有被引用时对这个对象调用的。它是在 Object 类中定义的，因此所有的类都继承了它。子类覆盖 finalize() 方法以整理系统资源或者执
行其他清理工作。finalize() 方法是在垃圾收集器删除对象之前对这个对象调用的。
 
  */

/**
 * Java中final、finally和finalize的区别（转） http://www.cnblogs.com/bluestorm/archive/2012/04/22/2464746.html
 * @author levi
 *
 */
public class FinalAndFinallyAndFinalizePractice {
 
	public final String s = "hello";
	public final int i = 20;
	
	public static final int STATIC_E;
	
	static{
		STATIC_E = 22;
	}
	
	//TODO final还可以修饰方法和类
	
	public static void main(String[] args) {
		//STATIC_E = 22;  final修饰的变量为常量，不能再次赋值
		
		System.out.println("STATIC_E是一个常量：" + STATIC_E);
		
		FinalizeTest ft = new FinalizeTest();
		ft = null;
		System.gc();
		
		try{
			throw new Exception("刻意的异常！");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("finally code ...");
		}
	
	
	}

}


final class FinalizeTest{
	//重写finalize()方法
	protected void finalize() throws Throwable{
		System.out.println("执行类finalize（）方法");
	} 
		
	
}