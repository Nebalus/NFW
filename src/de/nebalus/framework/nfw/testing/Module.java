package de.nebalus.framework.nfw.testing;

public class Module {
	
	protected String moduleVersion;
	
	/**
	 * Returns the current module version
	 * 
	 * @throws NullPointerException if the version of the {@code Module}
	 *         is null
	 * 
	 * @return The version of this {@code Module} as a {@code String} 
	 */
	public String getModuleVersion() {
		if(moduleVersion != null)
			throw new NullPointerException("There is no information about the module");
			
		return moduleVersion;
	}
}
