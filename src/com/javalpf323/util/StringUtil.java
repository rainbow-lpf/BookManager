package com.javalpf323.util;

public class StringUtil {

	public static boolean IsEmpty(String value) {
		if(value.trim()==""||"".equals(value.trim())){
			return true;
		}
		return false;
	}
	
	public static boolean IsNotEmpty(String value) {
		if(value.trim()!="") {
			return true;
		}
		return false;
	}
}
