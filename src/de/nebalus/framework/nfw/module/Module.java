package de.nebalus.framework.nfw.module;

public class Module {
	
	protected final ModuleType moduleType;
	
	protected Module(ModuleType moduleType) {
		this.moduleType = moduleType;
	}
	
	public final ModuleType getModuleType()
	{
		return moduleType;
	}
	
}
