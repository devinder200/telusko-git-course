package com.example.SpringBootSecurityTest.filter;

import com.example.SpringBootSecurityTest.service.JwtService;
import com.example.SpringBootSecurityTest.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

         //   String authHeader = request.getHeader("AUTHORIZATION");
            String token = null;
            String username = null;

            try{
                //Below code is user for API approch
//                if(authHeader !=null && authHeader.startsWith("Bearer ")){
//                    token = authHeader.substring(7);
//                    username = jwtService.extractUsername(token);
//                }

                //below code is used for jsp page with jwt token approach
                token = getTokenFromRequest(request);
                if(token !=null){
                    username = jwtService.extractUsername(token);
                }

                //checking if username is not null Authentication has not been done yet
                if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null){
                    UserDetails userDetails = applicationContext.getBean(MyUserDetailsService.class).loadUserByUsername(username);
                    if(userDetails != null && jwtService.validateToken(token, userDetails)){
                        //After validating with jwtFilter, we are directing it towards UsernamePasswordAuthenticationFilter
                        UsernamePasswordAuthenticationToken authToken =
                                new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authToken);

                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            //passing on to next filter
            filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request){
        if(request.getCookies()!=null){
            for(Cookie cookie: request.getCookies()){
                if("jwtToken".equals(cookie.getName())){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
