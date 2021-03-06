package com.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Student{
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Student(int a) {
		super();
		this.a = a;
	}
	
}

public class MyHashMap {

	public static void main(String[] args) {
		Student str1=new Student(2);
		Student str2=new Student(2);
		String str3="1";
		String str4="1";
		System.out.println(str1.equals(str2));
		System.out.println(hash(str1.hashCode()));
		System.out.println(hash(str2.hashCode()));
		
		System.out.println(str3.equals(str4));
		System.out.println(hash(str3.hashCode()));
		System.out.println(hash(str4.hashCode()));
		
		Map a=new HashMap();
		a.put("a", "123");
		a.put("c", str1);
		a.put(str1, str2);
		
		Iterator ai= a.keySet().iterator();
		while(ai.hasNext()){
			Object key=ai.next();
			System.out.println(a.get(key));
		}
		
	}
	

static int hash(int h) 
{ 
    h ^= (h >>> 20) ^ (h >>> 12); 
    return h ^ (h >>> 7) ^ (h >>> 4); 
}

}
