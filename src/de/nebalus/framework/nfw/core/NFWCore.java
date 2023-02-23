package de.nebalus.framework.nfw.core;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import de.nebalus.framework.nfw.module.ModuleType;
import de.nebalus.framework.nfw.testing.Module;
import de.nebalus.framework.nfw.utils.logger.Logger;

public final class NFWCore {
	
	public static final String FRAMEWORKNAME = "NebalusFrameWork";
	public static final String FRAMEWORKVERSION = "0.0.1";
	public static final String GITHUBREPO = "https://github.com/Nebalus/NFW";
	public static final String AUTHOR = "Nebalus";
	
	private static NFWCache CACHE;
	
	/**
	 * Loads the framework
	 */
	public static synchronized void load() {
		if(CACHE != null && CACHE.isLoaded) return;
		
		Logger.logInfo("Loading the " + FRAMEWORKNAME + " v" + FRAMEWORKVERSION + " by: " + AUTHOR + ", Github: " + GITHUBREPO);
		
		CACHE = new NFWCache();
		CACHE.startUpTimeStamp = System.currentTimeMillis();
		
		CACHE.registerModule(ModuleType.DCBOTBUILDER);		
		
		CACHE.loadStartUpMS = System.currentTimeMillis() - CACHE.startUpTimeStamp;
		
		Logger.logInfo(FRAMEWORKNAME + " v" + FRAMEWORKVERSION + " has been loaded! [" + CACHE.loadStartUpMS + "ms]");
		CACHE.isLoaded = true;
	}
	
	/**
	 * Unloads the framework and flushes all the cached data
	 */
	public static synchronized void unload() {
		if(CACHE != null && !CACHE.isLoaded) return;
		
		CACHE = null;
	}
	
	/**
	 * @return if the framework is initialized
	 */
	public static boolean isLoaded()
	{
		return CACHE != null ? CACHE.isLoaded : false;
	}
}

final class NFWCache {
	
	public boolean isLoaded = false;  // If the framework is fully initialized 
	
	public long startUpTimeStamp = 0l;  // The timestamp when the load() methode is executed
	public long loadStartUpMS = 0l;  // The startup duration for how long the load() methode took to finish

	public HashMap<Class<? extends Module>, Module> loadedModules = new HashMap<>();

	public void registerModule(Class<? extends Module> moduleClass) {
		if(loadedModules.containsKey(moduleClass)) return;
		
		try {
			Constructor<? extends Module> obj = moduleClass.getConstructor();
			Module module = obj.newInstance();
			loadedModules.put(moduleClass, module);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void registerModule(ModuleType moduleType)
	{
		registerModule(moduleType.getModuleClass());
	}
}