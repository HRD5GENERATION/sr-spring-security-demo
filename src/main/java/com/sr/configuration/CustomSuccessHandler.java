package com.sr.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		System.out.println("->Login Successfully!");
		
		String redirectUrl = (String) request.getSession().getAttribute("REDIRECT_URL");
		
		if(redirectUrl == null){
			for(GrantedAuthority authorities: authentication.getAuthorities()){
				System.out.println(authorities.getAuthority());
				
				if(authorities.getAuthority().equals("ROLE_ADMIN")){
					redirectUrl = "/admin";
				}
				else if(authorities.getAuthority().equals("ROLE_DBA")){
					redirectUrl = "/dba";
				}
				else if(authorities.getAuthority().equals("ROLE_USER")){
					redirectUrl = "/user";
				}
			}
		}
		response.sendRedirect(redirectUrl);
	}
}










