package com.jwtsecurity.configs;

import com.jwtsecurity.exception.JwtSignatureException;
import com.jwtsecurity.repository.TokenRepository;
import io.jsonwebtoken.security.SignatureException;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {



  private final JwtService jwtService;

  private final UserDetailsService userDetailsService;

  private final TokenRepository tokenRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
    String authHeader = request.getHeader("Authorization");
    if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")){
      String jwt = authHeader.substring(7);
      if(jwt == null || jwt.isBlank()){
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token in Bearer Header");
      }else {
        try{
          String email = jwtService.extractUsername(jwt);
          UserDetails userDetails = userDetailsService.loadUserByUsername(email);
          UsernamePasswordAuthenticationToken authToken =
                  new UsernamePasswordAuthenticationToken(email, userDetails.getPassword(), userDetails.getAuthorities());
          if(SecurityContextHolder.getContext().getAuthentication() == null){
            SecurityContextHolder.getContext().setAuthentication(authToken);
          }
        }catch(SignatureException exc){
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
        }

      }
    }

    filterChain.doFilter(request, response);
  }

//  @Override
//  protected void doFilterInternal(
//      @NonNull HttpServletRequest request,
//      @NonNull HttpServletResponse response,
//      @NonNull FilterChain filterChain
//  ) throws ServletException, IOException {
//    if (request.getServletPath().contains("/api/v1/auth")) {
//      filterChain.doFilter(request, response);
//      return;
//    }
//    final String authHeader = request.getHeader("Authorization");
//    final String jwt;
//    final String userEmail;
//    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
//      filterChain.doFilter(request, response);
//      return;
//    }
//    jwt = authHeader.substring(7);
//
////    try {
//      userEmail = jwtService.extractUsername(jwt);
////    }catch (SignatureException exception){
////      throw new JwtSignatureException(exception.getMessage());
////    }
//
//    if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
//      var isTokenValid = tokenRepository.findByToken(jwt)
//          .map(t -> !t.isExpired() && !t.isRevoked())
//          .orElse(false);
//      if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
//        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//            userDetails,
//            null,
//            userDetails.getAuthorities()
//        );
//        authToken.setDetails(
//            new WebAuthenticationDetailsSource().buildDetails(request)
//        );
//        SecurityContextHolder.getContext().setAuthentication(authToken);
//      }
//    }
//    filterChain.doFilter(request, response);
//  }
}