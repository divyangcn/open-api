package com.capital.number;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainClass {
	public static void main(String[] args) throws ParseException {
		String str = "24 December 2022 7pm";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMMM yyyy hha");
		System.out.println(dateFormat.parse(str));
		
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}
}
