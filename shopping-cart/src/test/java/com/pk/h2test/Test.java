package com.pk.h2test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test {

	public static void main(String[] args) {

		SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm");
		timeFormatter.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
		String now = timeFormatter.format(new Date());
		
		System.out.println(now);
		
		String[] hours = now.split(":");
		
		int hour = Integer.valueOf(hours[0]);
		
		String wish="";
		if(hour<12) {
			wish = "Good Morning";
		}else if(hour>12&&hour<19) {
			wish = "Good Evening";
		}else if(hour>19&&hour<24) {
			wish  = "Good Night";
		}
		
		System.out.println(wish);

	}
}
