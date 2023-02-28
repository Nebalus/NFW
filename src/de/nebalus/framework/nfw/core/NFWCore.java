package de.nebalus.framework.nfw.core;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import de.nebalus.framework.nfw.module.Module;
import de.nebalus.framework.nfw.module.ModuleType;
import de.nebalus.framework.nfw.utils.logger.Logger;

public final class NFWCore {
	
	public static final String FRAMEWORKNAME = "NebalusFrameWork";
	public static final String FRAMEWORKVERSION = "0.0.1";
	public static final String GITHUBREPO = "https://github.com/Nebalus/NFW";
	public static final String AUTHOR = "Nebalus";
}
//  private static NFWCache CACHE;
//	/**
//	 * Loads the framework
//	 */
//	public static synchronized void load() {
//		if(isLoaded()) return;
//		
//		Logger.logInfo("Loading the " + FRAMEWORKNAME + " v" + FRAMEWORKVERSION + " by: " + AUTHOR + ", Github: " + GITHUBREPO);
//		
//		CACHE = new NFWCache();
//		CACHE.startUpTimeStamp = System.currentTimeMillis();
//		
//		for(ModuleType mtype : ModuleType.values()) {
//			CACHE.loadModule(mtype);
//		}
//		
//		CACHE.loadStartUpMS = System.currentTimeMillis() - CACHE.startUpTimestamp;
//		
//		Logger.logInfo(FRAMEWORKNAME + " v" + FRAMEWORKVERSION + " has been loaded! [" + CACHE.loadStartUpMS + "ms]");
//		CACHE.isLoaded = true;
//		
//		Logger.logInfo("Starting Executable Programm...");
//	}
//	
//	/**
//	 * Unloads the framework and flushes all the cached data
//	 */
//	public static synchronized void unload() {
//		if(!isLoaded()) return;
//		
//		CACHE = null;
//	}
//	
//	/**
//	 * @return if the framework is initialized
//	 */
//	public static boolean isLoaded()
//	{
//		return CACHE != null ? CACHE.isLoaded : false;
//	}
//
//	public static Module getModule(ModuleType moduleType) throws IllegalAccessException
//	{
//		if(!isLoaded()) throw new IllegalAccessException("The " + FRAMEWORKNAME + " is not loaded");
//		if(!CACHE.loadedModules.containsKey(moduleType.getModuleClass())) throw new IllegalAccessException("The " + moduleType.name() + " module is not loaded");
//		Module module;
//		if((module = CACHE.loadedModules.get(moduleType.getModuleClass())) == null) throw new NullPointerException("The " + moduleType.name() + " module is not loaded correctly");
//		
//		return module;
//	}
//}
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
//	public void loadModule(Class<? extends Module> moduleClass) {
//		if(loadedModules.containsKey(moduleClass)) return;
//		
//		try {
//			Constructor<? extends Module> obj = moduleClass.getConstructor();
//			Module module = obj.newInstance();
//			loadedModules.put(moduleClass, module);
//			Logger.logDebug(moduleClass.getSimpleName() + " Module loaded... v" + module.getModuleType().getModuleVersion() + " " + module.getModuleType().getDescription());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//	
//	public void loadModule(ModuleType moduleType)
//	{
//		loadModule(moduleType.getModuleClass());
//	}
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
