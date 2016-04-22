package com.mottledog.javabasic;


/**
 * strictfp，Java关键字，即strict float point（精确浮点）
 * 
 * stricttp关键字可引用于类、接口或方法。使用strictfp关键字声明一个方法时，该方法中所有float和double表达式都严格
 * 遵守FP-strict的限制，符合IEEE-754规范。当对一个类或接口使用strictfp关键字时，该类中的所有代码，包括嵌套类型中
 * 的初始设定值和代码，都严格地进行计算。严格越俗意味着所有表达式的结果都必须是IEEE754算法对操作数预期的结果，以单
 * 精度和双精度格式表示。
 * 
 * 如果想让浮点运算更加精确，而且不会因为不同的硬件平淡所执行的结果不一致的话，可以用关键字strictfp。
 * 可以将一个类、接口以及方法声明为strictfp，但是不允许对接口中的方法以及构造函数声明strictfp关键字
 * @author levitian
 *
 */
public strictfp class KeyWordStrictfpTest {

	public static void main(String[] args){
		float aFloat = 0.6710339f;

		double aDouble = 0.04150553411984792d;

		double sum = aFloat + aDouble;

		float quotient = (float)(aFloat / aDouble);

		System.out.println("float: " + aFloat);

		System.out.println("double: " + aDouble);

		System.out.println("sum: " + sum);

		System.out.println("quotient: " + quotient);
		
/*		float: 0.6710339
		double: 0.04150553411984792
		sum: 0.7125394529774224
		quotient: 16.167336
*/

	}
}

class KeyWordStrictfpTest2 {
	public float aFloat;

	public double aDouble;

	public KeyWordStrictfpTest2() {
	}

	public strictfp double add(float a, double b){
		return (a + b);
	}

	public static void main(String[] args){

		KeyWordStrictfpTest2 myClass2 = new KeyWordStrictfpTest2();

		myClass2.aFloat = 0.6710339f;

		myClass2.aDouble = 0.04150553411984792d;

		double sum = myClass2.add(myClass2.aFloat, myClass2.aDouble);

		System.out.println("float: " + myClass2.aFloat);

		System.out.println("double: " + myClass2.aDouble);

		System.out.println("sum: " + sum);

	}
}
