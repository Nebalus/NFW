package de.nebalus.dcbots.melody.core;

import de.nebalus.dcbots.melody.listener.InteractionListener;
import de.nebalus.framework.nfw.core.NFWCore;
import de.nebalus.framework.nfw.module.ModuleType;
import de.nebalus.framework.nfw.utils.logger.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Melody
{
	public static Melody BOTINSTANCE;
	
	public static void main(String[] args)
	{
		NFWCore.loadFramework(ModuleType.DCBOTBUILDER); // Loads the needed modules
			
		try
		{	
			BOTINSTANCE = new Melody();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private final JDA jda;
	
	private final Long startUpTimestamp; 
	
	private Melody() throws Exception
	{
		Logger.log("Building Melodys gateway connection to Discord...");
		
		startUpTimestamp = System.currentTimeMillis();
		
		JDABuilder builder = JDABuilder.create(GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_VOICE_STATES);
		
		builder.setToken("");
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setActivity(Activity.playing("booting myself..."));
		builder.setMemberCachePolicy(MemberCachePolicy.VOICE.or(MemberCachePolicy.ONLINE));
		builder.setChunkingFilter(ChunkingFilter.NONE);
		builder.setLargeThreshold(50);
		builder.addEventListeners(new InteractionListener());
		
		jda = builder.build();
		jda.awaitReady();
		
		Logger.log("Melodys connection was succesfully build in " + (System.currentTimeMillis() - startUpTimestamp) + "ms");	
	}
}
