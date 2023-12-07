package com.yblog.security.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        String errorMessage;

        if (exception instanceof BadCredentialsException) {
            errorMessage = "0";
        } else if (exception instanceof InternalAuthenticationServiceException) {
            errorMessage = "1";
        } else if (exception instanceof UsernameNotFoundException) {
            errorMessage = "2";
        } else if (exception instanceof AuthenticationCredentialsNotFoundException) {
            errorMessage = "3";
        } else {
            errorMessage = "4";
        }

        setDefaultFailureUrl("/loginHandler?error=true&exception=" + errorMessage);

        super.onAuthenticationFailure(request, response, exception);
    }
}