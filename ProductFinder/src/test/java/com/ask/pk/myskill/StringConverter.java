package com.ask.pk.myskill;

import java.util.ArrayList;

public class StringConverter {
	
	private static final ArrayList<String> smallApha = new ArrayList<String>();
	
	static {
		smallApha.add(0,"a");
		smallApha.add(1,"b");
		smallApha.add(2,"c");
		smallApha.add(3,"d");
		smallApha.add(4,"e");
		smallApha.add(5,"f");
		smallApha.add(5,"f");
		smallApha.add(5,"f");
		smallApha.add(5,"f");
		
		smallApha.add(5,"f");
		smallApha.add(5,"f");
		smallApha.add(5,"f");
		smallApha.add(5,"f");
		smallApha.add(5,"f");
	}
	
	public static void main(String[] args) {
		
		
		
		
		String str= "ace";
		char[] strArr = str.toCharArray();
		
		String returnStr = "";
		for(char c : strArr) {
			
			if(returnStr.isEmpty()) {
			
				returnStr = smallApha.get(smallApha.indexOf(c+"")+1);
			}else {
				returnStr = returnStr+ smallApha.get(smallApha.indexOf(c+"")+1);
			}
		}
		
		System.out.println(returnStr);
	}

}
