package de.nebalus.dcbots.testbot;

import javax.security.auth.login.LoginException;

import de.nebalus.framework.nfw.core.NFWCore;
import de.nebalus.framework.nfw.module.ModuleType;
import de.nebalus.framework.nfw.module.dcbotbuilder.DCBotBuilderModule;
import de.nebalus.framework.nfw.utils.logger.Logger;

public class BotCore 
{
	public static void main(String[] args)
	{
		try
		{
			NFWCore.load();
			
			//Logger.log(((DCBotBuilderModule) NFWCore.getModule(ModuleType.DCBOTBUILDER)));
			
			new BotCore();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private BotCore() throws LoginException
	{
		
	}
}
