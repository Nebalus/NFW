package de.nebalus.framework.nfw.module.dcbotbuilder;

import de.nebalus.framework.nfw.module.Module;
import de.nebalus.framework.nfw.module.ModuleType;
import de.nebalus.framework.nfw.utils.logger.Logger;

public final class DCBotBuilderModule extends Module {	

	public DCBotBuilderModule() {
		super(ModuleType.DCBOTBUILDER);
	}

	@Override
	public void onEnable() {
		Logger.log("TEST");
		
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

}
