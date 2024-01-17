package com.fightfoodwaste.useraccountservice.filter;

import com.fightfoodwaste.useraccountservice.utility.JsonExtract;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private final RequestMatcher requestMatcher = new AntPathRequestMatcher("/account/{id}");

    private final JsonExtract extract;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(requestMatcher.matches(request)){
            String jwtToken = extractJwtFromRequest(request);
            if(jwtToken != null){
                String accountIdFromToken = getAccountIdFromToken(jwtToken);
                String accountIdFromPath = extractAccountIdFromPath(request);
                if(!accountIdFromPath.equals(accountIdFromToken)){
                    System.out.println(accountIdFromPath);
                    System.out.println(accountIdFromToken);
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    return;
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private String extractAccountIdFromPath(HttpServletRequest request) {
        String path = request.getRequestURI();
        String contextPath = request.getContextPath();
        path = path.substring(contextPath.length());

        String[] parts = path.split("/");
        return parts.length > 2 ? parts[2] : null;
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private String getAccountIdFromToken(String token) {
        // You'll need to parse the JWT and extract the claim that contains the account ID
        return extract.getSubjectFromToken(token);
    }
}
