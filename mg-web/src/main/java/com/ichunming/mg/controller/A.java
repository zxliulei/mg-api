package com.ichunming.mg.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {

	public static void main(String[] args) {
		System.out.println(A.isMobileNO("15000791491"));

	}
public static boolean isMobileNO(String mobiles){  
		  
Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");  
		  
Matcher m = p.matcher(mobiles);
System.out.println(m.matches()+"---");
return m.matches();
} 

}
