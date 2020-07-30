package sh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import sh.components.LinuxCondition;
import sh.components.LinuxOSConfigImpl;
import sh.components.OSConfig;
import sh.components.WindowsCondition;
import sh.components.WindowsOSConfigImpl;

@Configuration
public class ComponentConfig {
	@Bean(name="osConfig")
	@Conditional(WindowsCondition.class)
	public OSConfig windowsOSConfig() {
		return new WindowsOSConfigImpl();
	}
	
	@Bean(name="osConfig")
	@Conditional(LinuxCondition.class)
	public OSConfig linuxOSConfig() {
		return new LinuxOSConfigImpl();
	}
}
