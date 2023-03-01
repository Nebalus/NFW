package de.nebalus.framework.nfw.module;

import de.nebalus.framework.nfw.module.dcbotbuilder.DCBotBuilderModule;
import de.nebalus.framework.nfw.module.minecraft.MinecraftModule;
import de.nebalus.framework.nfw.module.template.TemplateModule;
import de.nebalus.framework.nfw.module.ui.UIModule;

public enum ModuleType {

	DCBOTBUILDER(DCBotBuilderModule.class, "0.0.1", "This extends the JDA v5 API for making better Discord Bots", "Nebalus"),
	MINECRAFT(MinecraftModule.class, "0.0.1", "A libary with a lots of helpful stuff... MC v1.19 waiting to update to 1.20", "Nebalus"),
	TEMPLATE(TemplateModule.class, "0.0.1", "A simple Template", "Nebalus"),
	UI(UIModule.class, "0.0.1", "A simple Libary helps creating UI better", "Nebalus");
	
	private final Class<? extends Module> moduleClass;
	private final String moduleVersion;
	private final String moduleDescription;
	private final String moduleAuthor;
	
	ModuleType(Class<? extends Module> moduleClass, String moduleVersion, String moduleDescription, String moduleAuthor) {
		this.moduleClass = moduleClass;
		this.moduleVersion = moduleVersion;
		this.moduleDescription = moduleDescription;
		this.moduleAuthor = moduleAuthor;
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
	
	/**
	 * @return the current authors of the selected module
	 */
	public String getAuthor() {
		return moduleAuthor;
	}
}
