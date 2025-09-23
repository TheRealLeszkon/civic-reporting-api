package com.sih.michael.civilized_reporting_api.config;

import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.services.JWTService;
import com.sih.michael.civilized_reporting_api.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Bearer token_string
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username =null;

        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
            UserService userService = context.getBean(UserService.class);
            User user = userService.findUserByUsername(username);
            request.setAttribute("userId", user.getId());
        }

        if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = context.getBean(UserDetailsService.class).loadUserByUsername(username);

            if(jwtService.validateToken(token,userDetails)){
                UsernamePasswordAuthenticationToken UPAToken =
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                UPAToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(UPAToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
