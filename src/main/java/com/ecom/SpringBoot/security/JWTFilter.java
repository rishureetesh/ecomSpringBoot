package com.ecom.SpringBoot.security;

import com.ecom.SpringBoot.exceptions.UnauthorizedException;
import com.ecom.SpringBoot.service.CustomUserDetailService;
import io.jsonwebtoken.JwtException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Component
@Log4j2
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTSecurity jwtSecurity;

    @Autowired
    private CustomUserDetailService userDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, RuntimeException {
        try {
            String authorizationHeader = request.getHeader("Authorization");
            String cookie = getCookieFromRequest(request.getCookies());
            String token=null;
            String username=null;
            if(authorizationHeader!= null && authorizationHeader.startsWith("Bearer ")){
                token = authorizationHeader.substring(7);
                username = jwtSecurity.extractUsername(token);
            } else if (cookie != null) {
                token = cookie;
                username = jwtSecurity.extractUsername(token);
            }
            if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = userDetailService.loadUserByUsername(username);

                if (jwtSecurity.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }catch(RuntimeException ex){
            log.error("Authorization Failed!");
            log.error(ex);
            ((HttpServletResponse) response).setStatus(403);
            response.getOutputStream().write("Authorization Failed!".getBytes());
            return;
        }
        filterChain.doFilter(request,response);
    }

    private String getCookieFromRequest(Cookie[] cookies){
        if(cookies != null && cookies.length > 0)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ecomToken"))
                    return cookie.getValue();
            }
        return null;
    }
}
