package sh.components;

public class WindowsOSConfigImpl implements OSConfig {
	private String osName = "Windows";
	@Override
	public String getOsName() {
		return osName;
	}	
	
	@Override
	public Object getEmailService() {
		// Build email service for windows host
		return null;
	}
}
