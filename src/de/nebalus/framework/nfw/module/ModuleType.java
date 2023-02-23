package de.nebalus.framework.nfw.module;

import de.nebalus.framework.nfw.module.dcbotbuilder.DCBotBuilderModule;

public enum ModuleType {

	DCBOTBUILDER(DCBotBuilderModule.class);
	
	private Class<? extends Module> moduleClass;
	
	ModuleType(Class<? extends Module> moduleClass) {
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
