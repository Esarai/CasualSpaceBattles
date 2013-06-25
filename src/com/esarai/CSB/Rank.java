package com.esarai.CSB;

public class Rank {
	
	String name;
	boolean canModerate, canAdmin;
	
	public Rank(String s){
		name = s;
		canModerate = false;
		canAdmin = false;
	}
	
	public void changeName(String s){
		name = s;
	}
	
	public void setMod(boolean b) {
		canModerate = b;
	}
	
	public void setAdmin(boolean b) {
		canAdmin = b;
	}

}
