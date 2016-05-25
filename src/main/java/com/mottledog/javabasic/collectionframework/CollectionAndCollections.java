package com.mottledog.javabasic.collectionframework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 
1、java.util.Collection 是一个集合接口。它提供了对集合对象进行基本操作的通用接口方法。
Collection接口在Java 类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提
供了最大化的统一操作方式。
 Collection  
├List  
│├LinkedList  
│├ArrayList  
│└Vector  
│　└Stack  
└Set 
 2、java.util.Collections 是一个包装类。它包含有各种有关集合操作的静态多态方法。此类不
 能实例化，就像一个工具类，服务于Java的Collection框架。
 * @author tianl
 *
 */
public class CollectionAndCollections {
	public static void main(String args[]){
		//实例化Collection
		Collection<Object> c = new ArrayList<>();
		c.add("bbb");
		c.add("zzz");
		c.add("aaa");
		c.add("fff");
		
		List l = (List)c;
		System.out.println(l.size());
		//利用Collections工具类进行排序
		Collections.sort(l);
		for(Object o : l){
			System.out.print(o + "  ");
		}
		System.out.println();
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(112);
		list.add(342);
		list.add(164);
		list.add(672);
		
		for(Integer i : list){
			System.out.print(i + "  ");
		}
		Collections.sort(list);
		
		System.out.println("");
		System.out.println("------------");
		
		for(Integer i : list){
			System.out.print(i + "  ");
		}
		
	}
}
