package com.ldh.board.demo.global.security.handler;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        exception.printStackTrace();
        String error = getExceptionMessage(exception);

        error = URLEncoder.encode(error, "UTF-8");
        setDefaultFailureUrl("/user/login?error=true&exception="+ error);
        super.onAuthenticationFailure(request, response, exception);
    }

    private String getExceptionMessage(AuthenticationException exception) {
        if(exception instanceof BadCredentialsException){
            return "비밀번호가 일치하지 않습니다";
        } else if(exception instanceof UsernameNotFoundException) {
            return "해당 유저를 찾을 수 없습니다";
        } else {
            return "확인된 에러가 없습니다";
        }
    }
}
