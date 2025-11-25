package com.sist.dao;

import org.springframework.stereotype.Repository;

/*
 * 	  1. AOP
 * 		 Before
 *       After
 *       After-Throwing
 *       After-Returning
 *       Around
 *       
 *       public String display() {
 *       	String res = ""
 *          => Before
 *          try {
 *          	-------------- setAutoCommit(false) Around
 *          		코딩
 *          	--------------
 *          } catch(Exception ex) {
 *          	=> After-Throwing
 *          }
 *          finally {
 *          	=> After
 *         	}
 *         return res; => After-Returning
 *       }
 */
@Repository("dao")
public class MyDAO {
	public void getConnection() {
		System.out.println("🔔🔔🔔 오라클 연결 🔔🔔🔔");
	}
	
	public void disConnection() {
		System.out.println("🔒🔒🔒 오라클 해제 🔒🔒🔒");
	}
	
	public void select() {
		getConnection();
		System.out.println("데이터 읽기");
		disConnection();
	}

	public void insert() {
		getConnection(); // Before
		System.out.println("데이터 추가");
		disConnection(); // After
	}

	public void update() {
		getConnection();
		System.out.println("데이터 수정");
		disConnection();
	}

	public void delete() {
		getConnection();
		System.out.println("데이터 삭제");
		disConnection();
	}
}
