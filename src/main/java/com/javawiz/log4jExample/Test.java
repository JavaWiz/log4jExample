package com.javawiz.log4jExample;

import org.apache.log4j.Logger;

public class Test {
	final static Logger logger = Logger.getLogger(HelloExample.class);
	public static void main(String[] args) {
		String cc = "1234567812345678";
    	logger.info("Credit Card : " + cc.substring(0, 4) + "-XXXX-XXXX-" + cc.substring(12));
    	logger.info("Credit Card : " + moreEfficient(cc));
	}
	
	public static String moreEfficient(String cc){
		StringBuilder sb = new StringBuilder();
		char[] buff = cc.toCharArray();
		sb.append(buff,12,buff.length-12);
		sb.append(buff , 0, 4).append("-XXXX-XXXX-");
		return sb.toString();
	}
}
