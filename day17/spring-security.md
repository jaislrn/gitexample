* Database 
	* create table for roles.

	create table roles(email varchar(50), role varchar(30));
	insert into roles values('admin@onlinebooks.com', 'ROLE_ADMIN');
	insert into roles values('nilesh@sunbeaminfo.com', 'ROLE_CUSTOMER');
	insert into roles values('prashant@onlinebooks.com', 'ROLE_CUSTOMER');
	insert into roles values('nitin@onlinebooks.com', 'ROLE_CUSTOMER');

* pom.xml
	<dependency>
		<groupId>org.springframework.security</groupId>
		<artifactId>spring-security-web</artifactId>
		<version>5.2.5.RELEASE</version>
	</dependency>

	<dependency>
		<groupId>org.springframework.security</groupId>
		<artifactId>spring-security-config</artifactId>
		<version>5.2.5.RELEASE</version>
	</dependency>

* SecurityWebApplicationInitializer.java --> springSecurityFilterChain configuration
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	// default settings
}

* SecurityConfig.java --> config of spring security filters

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
		.antMatchers("/details").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_CUSTOMER')")
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

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}

* Give appropriate patterns to controllers
	@RequestMapping("/admin")
	@RequestMapping("/customer")

* Create login page.
	<form method="post" action="j_spring_security_check">
		<table>
			<tr>
				<td>
					<s:message code="email.label"/>:
				</td>
				<td>
					<input type="text" name="email"/>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<s:message code="password.label"/>:
				</td>
				<td>
					<input type="password" name="password"/>
				</td>
				<td>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="<s:message code="signin.label"/>"/>
				</td>
				<td>
					<a href="register"><s:message code="signup.label"/></a>
				</td>
			</tr>
		</table>
		<a href="index?lang=en">English</a>
		<a href="index?lang=hi">Hindi</a>
	</form>

* Create logout page.


