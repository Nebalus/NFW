package de.nebalus.framework.nfw.module.dcbotbuilder;

public abstract class DCBotInstance 
{
	private boolean isLoaded = false;
	
	/**
	 * Checks if the BotInstance is loaded. If not then the onLoad() methode will be fired
	 */
	public final synchronized void load() throws Exception {
		if(isLoaded) return;
		
		isLoaded = false;
		onLoad();
	}
	
	/**
	 * Checks if the BotInstance is loaded. If true then the onUnload() methode will be fired
	 */
	public final synchronized void unload() throws Exception {
		if(!isLoaded) return;
		
		isLoaded = false;
		onUnload();
	}
	
	public final boolean isLoaded()	{
		return isLoaded;
	}
	
	protected abstract void onLoad() throws Exception;
	
	protected abstract void onUnload() throws Exception;
}
