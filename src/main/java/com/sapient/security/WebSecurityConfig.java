package com.sapient.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	      .httpBasic().and()
	      .authorizeRequests()
	      	.antMatchers(HttpMethod.GET, "/getAll").hasRole("ADMIN")
	        .antMatchers(HttpMethod.POST, "/create").hasRole("ADMIN")
	        .antMatchers(HttpMethod.PUT, "/update/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.DELETE, "/delete/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.DELETE, "/deleteAll/**").hasRole("ADMIN")
	        .and().csrf().disable();
	
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
	      .withUser( env.getProperty("myuser.name")).password(env.getProperty("myuser.password")).roles("USER","ADMIN");
	      
		
	}

	

}
