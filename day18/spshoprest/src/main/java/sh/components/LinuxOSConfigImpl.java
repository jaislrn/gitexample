package sh.components;

public class LinuxOSConfigImpl implements OSConfig {
	private String osName = "Linux";
	@Override
	public String getOsName() {
		return osName;
	}	
	
	@Override
	public Object getEmailService() {
		// Build email service for linux host
		return null;
	}
}
