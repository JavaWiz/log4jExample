package com.javawiz.log4jExample;
import org.apache.log4j.Logger;

public class HelloExample{

	final static Logger logger = Logger.getLogger(HelloExample.class);

	public static void main(String[] args) {

		String card = "Aaaa bbbb aaa=1234567890123456 fdfdfd=aaa";
		logger.info("Credit Card : " + card);

	    String card1 = "Aaaa bbbb aaa=\"12345678901234561\" fdfdfd=aaa";
	    logger.info("Credit Card : " + card1);
	    
	    String card2 = "Aaaa bbbb aaa=1gfg23fgfg4567123123fdfdfd=aaa";
	    logger.info("Credit Card : " + card2);
	    
		String card3 = "<cardNumber>1234567812345678</cardNumber>";
    	logger.info("Credit Card : " + card3);
    	
    	String pan = "Aaaa bbbb aaa=1234567890 fdfdfd=aaa";
    	logger.info("PAN : " + pan);
    	
    	String pan1 = "Aaaa bbbb aaa=\"1234567890\" fdfdfd=aaa";
    	logger.info("PAN : " + pan1);
    	
    	String pan2 = "<accountNumber>7812345678</accountNumber>";
    	logger.info("PAN : " + pan2);
    	
    	String pan3 ="6754265443";
    	logger.info("PAN : " + pan3);
	}
}