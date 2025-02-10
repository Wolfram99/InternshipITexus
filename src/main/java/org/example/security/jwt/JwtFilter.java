package org.example.security.jwt;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUserDetailsService service;
    private final JwtTokenProvider provider;

    @Autowired
    public JwtFilter(JwtUserDetailsService service, JwtTokenProvider provider) {
        this.service = service;
        this.provider = provider;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromRequest(request);
        if(token != null && provider.validateJwtToken(token)){
            setUserDetailsToSecurityContextHolder(token);
        }
        filterChain.doFilter(request,response);



    }

    private void setUserDetailsToSecurityContextHolder(String token) {
        String username = provider.getUsernameFromToken(token);
        JwtUserDetails jwtUserDetails = service.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jwtUserDetails,
                                                            null, jwtUserDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

    }


    private String getTokenFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }

        return null;
    }




}
