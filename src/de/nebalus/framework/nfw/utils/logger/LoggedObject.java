package de.nebalus.framework.nfw.utils.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class LoggedObject {

	private final Long creationTimeStamp;		
	private final LogType logType;
	private final String logPrefixText;
	private final Object message; 
	
	private final String fullMessage; 
	
	public LoggedObject(Long creationTimeStamp, LogType logType, String logPrefixText, Object message) {
		
		this.creationTimeStamp = creationTimeStamp;
		this.logType = logType;
		this.logPrefixText = logPrefixText;
		this.message = message;
	
		String messagePrefix = "";
		
		SimpleDateFormat timestampFormat = new SimpleDateFormat("<HH:mm:ss>");
		messagePrefix += timestampFormat.format(new Date(creationTimeStamp)) + " "; 
		
		if(logType.getPrefix() != null || logPrefixText != null) {
			
			messagePrefix += "[";
			
			if(logType.getPrefix() != null && logPrefixText != null) {
				
				messagePrefix += logPrefixText;
				messagePrefix += ":";
				messagePrefix += logType.getPrefix();
				
			} else {
				
				if(logPrefixText != null) {
					messagePrefix += logPrefixText;
				}
				
				if(logType.getPrefix() != null) {
					messagePrefix += logType.getPrefix();
				}
				
			}
			
			messagePrefix += "]: ";
		}
		
		messagePrefix += message;
		
		fullMessage = messagePrefix;
	}
	
	public Long getCreationTimestamp()
	{
		return creationTimeStamp;
	}
	
	public LogType getType()
	{
		return logType;
	}
	
	public String getLogPrefixText()
	{
		return logPrefixText;
	}
	
	public Object getMessage()
	{
		return message;
	}
	
	public String getFullMessage()
	{
		return fullMessage;
	}
}





//public final class LoggedObject {
//
//	private final Long creationTimeStamp;		
//	private final LogType logType;
//	private final Class<?> logClass;
//	private final Object message; 
//	
//	private final String fullMessage; 
//	
//	public LoggedObject(Long creationTimeStamp, LogType logType, Class<?> logClass, Object message) {
//		
//		this.creationTimeStamp = creationTimeStamp;
//		this.logType = logType;
//		this.logClass = logClass;
//		this.message = message;
//	
//		String messagePrefix = "";
//		
//		SimpleDateFormat timestampFormat = new SimpleDateFormat("<HH:mm:ss>");
//		messagePrefix += timestampFormat.format(new Date(creationTimeStamp)) + " "; 
//		
//		if(logType.getPrefix() != null || (logClass != null && logClass.getSimpleName() != null)) {
//			
//			messagePrefix += "[";
//			
//			if(logType.getPrefix() != null && (logClass != null && logClass.getSimpleName() != null)) {
//				
//				messagePrefix += logClass.getSimpleName();
//				messagePrefix += ":";
//				messagePrefix += logType.getPrefix();
//				
//			} else {
//				
//				if((logClass != null && logClass.getSimpleName() != null)) {
//					messagePrefix += logClass.getSimpleName();
//				}
//				
//				if(logType.getPrefix() != null) {
//					messagePrefix += logType.getPrefix();
//				}
//				
//			}
//			
//			messagePrefix += "]: ";
//		}
//		
//		messagePrefix += message;
//		
//		fullMessage = messagePrefix;
//	}
//	
//	public Long getCreationTimestamp()
//	{
//		return creationTimeStamp;
//	}
//	
//	public LogType getType()
//	{
//		return logType;
//	}
//	
//	public Class<?> getLogClass()
//	{
//		return logClass;
//	}
//	
//	public Object getMessage()
//	{
//		return message;
//	}
//	
//	public String getFullMessage()
//	{
//		return fullMessage;
//	}
//}
