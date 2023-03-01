package de.nebalus.framework.nfw.core;

import java.util.Map.Entry;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

import de.nebalus.framework.nfw.core.exception.FrameworkException;
import de.nebalus.framework.nfw.core.exception.FrameworkRuntimeException;
import de.nebalus.framework.nfw.module.Module;
import de.nebalus.framework.nfw.module.ModuleType;
import de.nebalus.framework.nfw.utils.logger.Logger;

public final class NFWCore {
	
	public static final String FRAMEWORKNAME = "NebalusFrameWork";
	public static final String FRAMEWORKVERSION = "0.0.1";
	public static final String GITHUBREPO = "https://github.com/Nebalus/NFW";
	public static final String AUTHOR = "Nebalus";
	
	private static boolean isLoaded = false;  // If the framework is fully initialized 
	private static boolean isLoading = false; // If the framework is initializing
	
	private static ConcurrentHashMap<ModuleType, Module> enabledModules;
	
	/**
	 * Loads the framework instance
	 */
	public static synchronized void loadFramework(ModuleType... moduletypes) {
		if(isLoaded()) throw new FrameworkRuntimeException("The " + FRAMEWORKNAME + " is allready loaded");
		if(isLoading()) throw new FrameworkRuntimeException("The " + FRAMEWORKNAME + " is loading allready... please wait");
		
		isLoading = true;
		
		Logger.logInfo("Loading the " + FRAMEWORKNAME + " v" + FRAMEWORKVERSION + " by: " + AUTHOR + ", Github: " + GITHUBREPO);
		
		long startUpTimestamp = System.currentTimeMillis();
		
		enabledModules = new ConcurrentHashMap<ModuleType, Module>();
		
		for(ModuleType mtype : moduletypes) {
			enableModule(mtype);
		}
		
		long loadStartUpMS = System.currentTimeMillis() - startUpTimestamp;
		
		Logger.logInfo(FRAMEWORKNAME + " v" + FRAMEWORKVERSION + " has been loaded! [" + loadStartUpMS + "ms]");
		isLoaded = true;
		isLoading = false;
		
		Logger.logInfo("Starting Executable Programm...");
	}
	
	/**
	 * Unloads the framework and flushes all the cached data
	 */
	public static synchronized void unloadFramework() {
		if(!isLoaded()) throw new FrameworkRuntimeException("The " + FRAMEWORKNAME + " is not loaded");
		if(isLoading()) throw new FrameworkRuntimeException("The " + FRAMEWORKNAME + " is still loading");
		
		Logger.logInfo("Unloading the " + FRAMEWORKNAME + " v" + FRAMEWORKVERSION);
		
		for(Entry<ModuleType, Module> entry : enabledModules.entrySet())
		{
			disableModule(entry.getKey());
		}
		
		isLoaded = false; // Place at the end of this methode
	}
	
	/**
	 * @return {@Code true} if the framework is fully initialized/loaded
	 */
	public static boolean isLoaded()
	{
		return isLoaded;
	}

	/**
	 * @return {@Code true} if the framework is initializing
	 */
	public static boolean isLoading()
	{
		return isLoading;
	}
	
	/**
	 * 
	 * @param moduleType
	 */
	public static synchronized void enableModule(ModuleType moduleType)
	{
		if(!isLoaded() && !isLoading()) throw new FrameworkRuntimeException("The " + FRAMEWORKNAME + " is not loaded");
		if(enabledModules.containsKey(moduleType)) throw new FrameworkRuntimeException("The module '" + moduleType.name() + "' is allready enabled");
		
		Class<? extends Module> moduleClass = moduleType.getModuleClass();
		String moduleName = moduleClass.getSimpleName();
		
		try {
			Constructor<? extends Module> constructor = moduleClass.getConstructor();
			Module module = constructor.newInstance();
			
			Logger.logDebug("Enabling module '" + moduleName + "' v" + moduleType.getModuleVersion() + "...");
			
			module.onEnable();
			enabledModules.put(moduleType, module);
			
			Logger.logDebug("'" + moduleName + "' v" + moduleType.getModuleVersion() + " module enabled!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static synchronized void disableModule(ModuleType moduleType)
	{
		if(!isLoaded() && !isLoading()) throw new FrameworkRuntimeException("The " + FRAMEWORKNAME + " is not loaded");
		if(!enabledModules.containsKey(moduleType)) throw new FrameworkRuntimeException("The module '" + moduleType.name() + "' is allready disabled");
		
		String moduleName = moduleType.getModuleClass().getSimpleName();
		Module module = enabledModules.get(moduleType);
		
		Logger.logDebug("Disabling module '" + moduleName + "' v" + moduleType.getModuleVersion() + "...");
		
		enabledModules.remove(moduleType);
		module.onDisable();
		
		Logger.logDebug("'" + moduleName + "' v" + moduleType.getModuleVersion() + " module disabled!");
	}
		
	public static Module getModule(ModuleType moduleType) throws FrameworkException
	{
		if(!isLoaded()) throw new FrameworkException("The " + FRAMEWORKNAME + " is not loaded");
		if(!enabledModules.containsKey(moduleType)) throw new FrameworkException("The module '" + moduleType.name() + "' is not enabled");
		
		return enabledModules.get(moduleType);
	}

}





//
//final class NFWCache {
//	
//	public boolean isLoaded = false;  // If the framework is fully initialized 
//	
//	public long startUpTimestamp = 0l;  // The timestamp when the load() methode is executed
//	public long loadStartUpMS = 0l;  // The startup duration for how long the load() methode took to finish
//
//	public HashMap<Class<? extends Module>, Module> loadedModules = new HashMap<>();
//
//	public void enableModule(Class<? extends Module> moduleClass) {
//		if(loadedModules.containsKey(moduleClass)) return;
//		
//		try {
//			Constructor<? extends Module> obj = moduleClass.getConstructor();
//			Module module = obj.newInstance();
//			module.onEnable();
//			loadedModules.put(moduleClass, module);
//			Logger.logDebug(moduleClass.getSimpleName() + " Module enabled... v" + module.getModuleType().getModuleVersion() + " " + module.getModuleType().getDescription());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//	
//	public void enableModule(ModuleType moduleType)
//	{
//		enableModule(moduleType.getModuleClass());
//	}
//
//	public void disableModule(Class<? extends Module> moduleClass) {
//		if(!loadedModules.containsKey(moduleClass)) return;
//		
//		Module module = loadedModules.get(moduleClass);
//		Logger.logDebug("Disabling " + module.getClass().getSimpleName() + "...");
//		module.onDisable();
//		Logger.logDebug(module.getClass().getSimpleName() + " disabled! v" + module.getModuleType().getModuleVersion());
//	}
//	
//	public void disableModule(ModuleType moduleType)
//	{
//		disableModule(moduleType.getModuleClass());
//	}
//
//}








//
//private static ConcurrentHashMap<Class<? extends Module>, Module> enabledModules = new ConcurrentHashMap<Class<? extends Module>, Module>();
//
//public static synchronized void enableModule(Class<? extends Module> moduleClass) {
//	if(enabledModules.containsKey(moduleClass)) return;
//	
//	try {
//		Constructor<? extends Module> obj = moduleClass.getConstructor();
//		Module module = obj.newInstance();
//		enabledModules.put(moduleClass, module);
//		Logger.logDebug(moduleClass.getSimpleName() + " Module enabled... v" + module.getModuleType().getModuleVersion() + " " + module.getModuleType().getDescription());
//	} catch (Exception ex) {
//		ex.printStackTrace();
//	}
//}
//
//@SuppressWarnings("unchecked")
//public static synchronized void enableModule(Class<? extends Module>... moduleClass) {
//	for(Class<? extends Module> mClass : moduleClass) {
//		enableModule(mClass);
//	}
//}
//
//public static synchronized void enableModule(ModuleType... moduleTypes) {
//	for(ModuleType mType : moduleTypes) {
//		enableModule(mType.getModuleClass());
//	}
//}
//
//public static Module getModule(ModuleType moduleType) throws IllegalAccessException
//{
//	if(!enabledModules.containsKey(moduleType.getModuleClass())) throw new IllegalAccessException("The " + moduleType.name() + " module is not enabled");
//	Module module;
//	if((module = enabledModules.get(moduleType.getModuleClass())) == null) throw new NullPointerException("The " + moduleType.name() + " module is not enabled correctly");
//	
//	return module;
//}
//
//public static Module getModule(ModuleType moduleType) throws IllegalAccessException
//{
//	if(!enabledModules.containsKey(moduleType.getModuleClass())) throw new IllegalAccessException("The " + moduleType.name() + " module is not enabled");
//	Module module;
//	if((module = enabledModules.get(moduleType.getModuleClass())) == null) throw new NullPointerException("The " + moduleType.name() + " module is not enabled correctly");
//	
//	return module;
//}
