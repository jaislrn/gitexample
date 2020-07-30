package sh.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:account.properties")
@EnableAspectJAutoProxy(proxyTargetClass = false)
@Configuration
@ComponentScan(basePackages = "sh")
public class AppConfig {

}
