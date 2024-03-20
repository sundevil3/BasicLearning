package org.prannoy.core.tests;

import org.apache.log4j.Logger;

public class Log4JEx{

final static Logger logger = Logger.getLogger(Log4JEx.class);
	
	private void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		if(logger.isTraceEnabled()){
			logger.trace("This is info : " + parameter);
		}
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}
	
	public static void main(String[] args) {
		
		Log4JEx obj = new Log4JEx();
		obj.runMe("prannoy");
		
	}
}