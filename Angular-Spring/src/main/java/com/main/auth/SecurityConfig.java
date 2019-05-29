//package com.main.auth;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable().authorizeRequests()
//			.antMatchers("/home").permitAll() //permitimos el acceso a /login a cualquiera
//			.antMatchers(HttpMethod.POST, "/login").permitAll() //permitimos el acceso a /login a cualquiera
//			.anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
//			.and()
//			
//            // Las peticiones /login pasaran previamente por este filtro
//			.addFilterBefore(new LoginFilter("/login", authenticationManager()),
//	                UsernamePasswordAuthenticationFilter.class)
//			
//			// Las dem�s peticiones pasar�n por este filtro para validar el token
//			.addFilterBefore(new AuthFilter(),
//	                UsernamePasswordAuthenticationFilter.class);
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// Creamos una cuenta de usuario por default
//		auth.inMemoryAuthentication()
//			.withUser("root")
//			.password("{noop}root")
//			.roles("ADMIN");
//	}
//}