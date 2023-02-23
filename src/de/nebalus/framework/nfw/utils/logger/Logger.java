package de.nebalus.framework.nfw.utils.logger;

import java.io.File;
import java.util.LinkedList;

public final class Logger {
	
	private static final LinkedList<LoggedObject> HISTORYLOG = new LinkedList<LoggedObject>();
	
	public static synchronized void log(LogType logType, Class<?> logClass, Object message)
	{
		final LoggedObject logged_object = new LoggedObject(System.currentTimeMillis(), logType, logClass, message);
		
		if(logType.shouldDisplayAsError())
		{
			System.err.println(logged_object.getFullMessage());
		}
		else
		{
			System.out.println(logged_object.getFullMessage());
		}
		
		HISTORYLOG.add(logged_object);
	}
	
	public static void log(LogType logType, Object message)
	{
		log(logType, null, message);
	}
	
	public static void log(Class<?> logType, Object message)
	{
		log(LogType.NORMAL, logType, message);
	}
	
	public static void log(Object message)
	{
		log(LogType.NORMAL, null, message);
	}
	
	public static void logError(Class<?> logType, Object message)
	{
		log(LogType.ERROR, logType, message);
	}
	
	public static void logError(Object message)
	{
		log(LogType.ERROR, null, message);
	}
	
	public static void logWarning(Class<?> logType, Object message)
	{
		log(LogType.WARNING, logType, message);
	}
	
	public static void logWarning(Object message)
	{
		log(LogType.WARNING, null, message);
	}
	
	public static void logInfo(Class<?> logType, Object message)
	{
		log(LogType.INFO, logType, message);
	}
	
	public static void logInfo(Object message)
	{
		log(LogType.INFO, null, message);
	}
	
	public static void logDebug(Class<?> logType, Object message)
	{
		log(LogType.DEBUG, logType, message);
	}
	
	public static void logDebug(Object message)
	{
		log(LogType.DEBUG, null, message);
	}
	
	public static void exportLog()
	{
		
	}
	
	public static void exportLog(File file)
	{
		
	}
}	
