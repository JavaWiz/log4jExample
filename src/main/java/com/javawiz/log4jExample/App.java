package com.javawiz.log4jExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static final Logger logger = LogManager.getLogger("HelloWorld");
    public static void main( String[] args )
    {
    	logger.info("Hello, World!");
    	String creditCardNum = "1234567812345678";
    	logger.info("Credit Card" + creditCardNum);
    }
}
