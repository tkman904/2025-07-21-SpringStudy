package com.sist.web;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names = {"홍길동", "심청이", "이순신", "박문수", "춘향이"};
		List<String> list = Arrays.asList(names);
		for(String name : list) {
			System.out.println(name);
		}
	}

}
