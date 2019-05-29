//package com.main.auth;
//import java.io.IOException;
//import java.util.Collections;
//
//import javax.security.sasl.AuthenticationException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class LoginFilter extends AbstractAuthenticationProcessingFilter {
//
//    public LoginFilter(String url, AuthenticationManager authManager) {
//        super(new AntPathRequestMatcher(url));
//        setAuthenticationManager(authManager);
//    }
//
//	@Override
//	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//			throws AuthenticationException, IOException, ServletException {
//		
//		// Asumimos que el body tendr� el siguiente JSON  {"username":"root", "password":"root"}
//        // Realizamos un mapeo a nuestra clase User para tener ahi los datos
//		
//		User credentials = new ObjectMapper()
//				.readValue(request.getInputStream(), User.class);
//		
//		// Finalmente autenticamos
//        // Spring comparar� el user/password recibidos
//        // contra el que definimos en la clase SecurityConfig
//		return getAuthenticationManager().authenticate(
//				new UsernamePasswordAuthenticationToken(
//						credentials.getUsername(), 
//						credentials.getPassword(),
//						Collections.emptyList()
//						)
//				);
//	}
//	
//	@Override
//	protected void successfulAuthentication(
//			HttpServletRequest request, 
//			HttpServletResponse response,
//			FilterChain filterChain,
//			Authentication auth) throws IOException, ServletException {
//		
//        // Si la autenticacion fue exitosa, agregamos el token a la respuesta
//		Token.addAuthentication(response, auth.getName());
//	}
//}
//
//class User {
//    private String username;
//    private String password;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}