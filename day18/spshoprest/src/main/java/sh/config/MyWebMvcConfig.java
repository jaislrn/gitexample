package sh.config;

import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
//@Import({HibernateConfig.class})
@ComponentScan(basePackages = "sh") // scans @Configuration, stereo-type annotations
public class MyWebMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public MappingJackson2HttpMessageConverter jsonConverter() {
		return new MappingJackson2HttpMessageConverter();
	}
	@Bean
	public MappingJackson2XmlHttpMessageConverter xmlConverter() {
		return new MappingJackson2XmlHttpMessageConverter();
	}
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(jsonConverter());
		converters.add(xmlConverter());
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/index");
	}
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(-1);
		return resolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSoure = new ReloadableResourceBundleMessageSource();
		messageSoure.setBasename("/WEB-INF/messages");
		messageSoure.setDefaultLocale(Locale.ENGLISH);
		return messageSoure;
	}
	
	@Bean
	public SimpleMappingExceptionResolver exceptionResolver() {
		SimpleMappingExceptionResolver exceptionResolver =  new SimpleMappingExceptionResolver();
		Properties props = new Properties();
		props.setProperty("java.lang.RuntimeException", "spec_error");
		exceptionResolver.setExceptionMappings(props);
		exceptionResolver.setDefaultErrorView("error");
		return exceptionResolver;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		return localeResolver;
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInteceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInteceptor());
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/static/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/static/js/");
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/static/images/");
		registry.addResourceHandler("/scripts/**").addResourceLocations("/WEB-INF/static/scripts/");
		registry.addResourceHandler("/themes/**").addResourceLocations("/WEB-INF/static/themes/");
	}
}
