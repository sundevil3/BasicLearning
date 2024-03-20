import org.apache.log4j.Logger;

public class Log4JMaven{
	
	final static Logger logger = Logger.getLogger(Log4JMaven.class);
	
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
		
		Log4JMaven obj = new Log4JMaven();
		obj.runMe("prannoy");
		
	}
	
}