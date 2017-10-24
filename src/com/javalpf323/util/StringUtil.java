package com.javalpf323.util;

public class StringUtil {

	public static boolean IsEmpty(String value) {
		
		if(value==null || "".equals(value.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean IsNotEmpty(String value) {
		if(value!=null && !"".equals(value.trim())){
			return true;
		}else{
			return false;
		}
	}
}
