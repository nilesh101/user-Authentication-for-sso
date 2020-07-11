package com.sso.demo.filter;

import com.sso.demo.configuration.TokenUtil;
import com.sso.demo.model.User;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class TokenFilter extends OncePerRequestFilter {

    @Autowired
    TokenUtil tokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("Authorization");

        String path = httpServletRequest.getRequestURI();

        //Exclude /auth URL as it won't contain token
        if("/auth".equals(path)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        } else if(!StringUtils.isEmpty(token)) {
            token = token.substring(7);
            User user = tokenUtil.getUserProfile(token);
            if(user != null) {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            } else {
                System.out.println("Not a valid token or token expired.");
                httpServletResponse.getWriter().write("Not a valid token or token expired");
                httpServletResponse.setStatus(400);
                return;
            }
        }
    }

}
