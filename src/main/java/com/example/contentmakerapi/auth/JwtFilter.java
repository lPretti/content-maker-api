package com.example.contentmakerapi.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String authorizationHeader = request.getHeader("Authorization");
       String username = null;
       String jwtToken = null;

       if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
           jwtToken = authorizationHeader.substring(7);
           username = jwtUtils.extractUsername(jwtToken);
       }
       if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
           UserDetails currentUserDetails = userService.loadUserByUsername(username);
            Boolean tokenValidated = jwtUtils.validateToken(jwtToken, currentUserDetails);
            if(tokenValidated) {
                final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(currentUserDetails, null);
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            }
       }

    }
}
