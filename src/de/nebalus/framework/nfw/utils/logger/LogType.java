package de.nebalus.framework.nfw.utils.logger;

public enum LogType {
	
	ERROR("ERROR", true),
	WARNING("WARNING", true),
	DEBUG("DEBUG", false),
	INFO("INFO", false),
	NORMAL(null, false);
	
	private final String prefix;
	private final boolean shouldDisplayAsError;
	
	LogType(String prefix, boolean shouldDisplayAsError) {
		this.prefix = prefix;
		this.shouldDisplayAsError = shouldDisplayAsError;
	}

	public String getPrefix() {
		return prefix;
	}
	
	public boolean shouldDisplayAsError() {
		return shouldDisplayAsError;
	}
}

