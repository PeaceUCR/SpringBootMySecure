package com.example.mysecuredemo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("Auth Success");
        System.out.println(authentication);
        HttpSession session = httpServletRequest.getSession(false);
        if (session != null) {
            String url = (String) httpServletRequest.getSession().getAttribute("url_prior_login");
            if (url != null) {
                System.out.println(url);
                httpServletResponse.sendRedirect(url);
            }else{
                httpServletResponse.sendRedirect("http://localhost:8080/home");
            }
        }
    }
}
