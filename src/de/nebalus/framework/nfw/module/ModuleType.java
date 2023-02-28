package de.nebalus.framework.nfw.module;

import de.nebalus.framework.nfw.module.dcbotbuilder.DCBotBuilderModule;
import de.nebalus.framework.nfw.module.minecraft.MinecraftModule;
import de.nebalus.framework.nfw.module.template.TemplateModule;
import de.nebalus.framework.nfw.module.ui.UIModule;

public enum ModuleType {

	DCBOTBUILDER(DCBotBuilderModule.class, "0.0.1", "This extends the JDA v5 API for making better Discord Bots"),
	MINECRAFT(MinecraftModule.class, "0.0.1", "A libary with a lots of helpful stuff... MC v1.19"),
	TEMPLATE(TemplateModule.class, "0.0.1", "A simple Template"),
	UI(UIModule.class, "0.0.1", "A simple Libary helps creating UI better");
	
	private final Class<? extends Module> moduleClass;
	private final String moduleVersion;
	private final String moduleDescription;
	
	ModuleType(Class<? extends Module> moduleClass, String moduleVersion, String moduleDescription) {
		this.moduleClass = moduleClass;
		this.moduleVersion = moduleVersion;
		this.moduleDescription = moduleDescription;
	}
	
	/**
	 * @return the module class of the selected module
	 */
	public Class<? extends Module> getModuleClass()
	{
		return moduleClass;
	}
	
	/**
	 * @return the current module version of the enum as a {@code String}
	 */
	public String getModuleVersion() {
		return moduleVersion;
	}
	
	/**
	 * @return the current module description of the enum as a {@code String}
	 */
	public String getDescription() {
		return moduleDescription;
	}
}
