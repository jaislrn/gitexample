package sh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "sh") // scans @Configuration, stereo-type annotations
public class AppConfig {

}
