package de.nebalus.framework.nfw.module;

import de.nebalus.framework.nfw.module.dcbotbuilder.DCBotBuilderModule;
import de.nebalus.framework.nfw.testing.Module;

public enum ModuleType {

	DCBOTBUILDER(DCBotBuilderModule.class, "0.0.1");
	
	private Class<? extends Module> moduleClass;
	
	ModuleType(Class<? extends Module> moduleClass, String version) {
		this.moduleClass = moduleClass;
	}
	
	/**
	 * @return the module class of the selected module
	 */
	public Class<? extends Module> getModuleClass()
	{
		return moduleClass;
	}
}
