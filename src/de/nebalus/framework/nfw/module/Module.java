package de.nebalus.framework.nfw.module;

public class Module {
	
	protected final ModuleType moduleType;
	
	public Module(ModuleType moduleType) {
		this.moduleType = moduleType;
	}
	
	public final ModuleType getModuleType()
	{
		return moduleType;
	}
	
}
