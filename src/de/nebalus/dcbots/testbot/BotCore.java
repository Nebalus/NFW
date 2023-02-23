package de.nebalus.dcbots.testbot;

import javax.security.auth.login.LoginException;

import de.nebalus.framework.nfw.core.NFWCore;

public class BotCore 
{
	public static void main(String[] args)
	{
		try
		{
			NFWCore.load();
			
			//new BotCore();
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
