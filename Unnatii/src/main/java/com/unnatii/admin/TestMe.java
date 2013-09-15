package com.unnatii.admin;

import java.util.Date;

public class TestMe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name1 = "test.jpg";
		
		Date date= new Date();
		
		System.out.println("my date is :" + date.getTime() );
		
		String[] nameStr = name1.split("\\.");
		System.out.println(nameStr.length);
		System.out.println(nameStr[0]+"_"+date.getTime()+"."+nameStr[1]);
	
		//System.out.println(nameStr[0] );

	}

}
