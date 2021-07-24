package com.example.contentmakerapi.auth;

import com.example.contentmakerapi.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private static final String HEADER_TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_AUTHORIZATION = "Authorization";

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserAuthService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
   /*   String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);
       String username = null;
       String jwtToken = null;

       if(authorizationHeader != null && authorizationHeader.startsWith(HEADER_TOKEN_PREFIX)){
           jwtToken = authorizationHeader.replace(HEADER_TOKEN_PREFIX,"");
           username = jwtUtils.extractUsername(jwtToken);
       }
       if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
           UserDetails currentUser = userService.loadUserByUsername(username);
            Boolean tokenValidated = jwtUtils.validateToken(jwtToken, currentUser);
            if(tokenValidated) {
                final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(currentUser, null);
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            }
       }*/
       filterChain.doFilter(request,response);
    }
}
