package sh.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource myDataSource;
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	private AuthenticationProvider authenticationProvider() {
		JdbcDaoImpl jdbcUserService = new JdbcDaoImpl();
		jdbcUserService.setDataSource(myDataSource);
		jdbcUserService.setUsersByUsernameQuery("select email, password, 1 AS enabled from customers where email=?");
		jdbcUserService.setAuthoritiesByUsernameQuery("select email, role from roles where email=?");
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(jdbcUserService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		System.out.println("security configured...");
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/customer/**").hasRole("CUSTOMER")
		//.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/j_spring_security_check")
		.defaultSuccessUrl("/auth", true)
		.usernameParameter("email")
		.passwordParameter("password")
		.failureUrl("/login")
		//.failureHandler(authenticationFailureHandler())
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/thanks")
		.invalidateHttpSession(true)
		//.logoutSuccessHandler(logoutSuccessHandler());
		.deleteCookies("JSESSIONID");
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}

