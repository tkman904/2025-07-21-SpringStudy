package com.sist.main3;

public class Student {
	private int hakbun;
	private Human hman = new Human();
	
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public Human getHuman() {
		return hman;
	}
	public void setHuman(Human human) {
		this.hman = human;
	}
}
