package de.nebalus.framework.nfw.module;

public abstract class Module {
	
	protected final ModuleType moduleType;
	
	public Module(ModuleType moduleType) {
		this.moduleType = moduleType;
	}
	
	public ModuleType getModuleType()
	{
		return moduleType;
	}

	public abstract void onEnable();
	
	public abstract void onDisable();
}
