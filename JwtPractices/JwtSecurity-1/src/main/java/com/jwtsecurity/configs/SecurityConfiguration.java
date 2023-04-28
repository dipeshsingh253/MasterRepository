package com.jwtsecurity.configs;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity(debug = true)
public class SecurityConfiguration {


    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;

    @Autowired
    private LogoutHandler logoutHandler;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/v1/auth/**").permitAll()
//                .antMatchers("/home/manager").hasRole("MANAGER")
//                .antMatchers("/home/comanager").hasRole("COMANAGER")
//                .antMatchers("/home/worker").hasRole("WORKER")
//                .anyRequest().authenticated();


        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .antMatchers("/api/v1/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/v1/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
//        http.csrf().disable()
//                .httpBasic().disable()
//                .cors()
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers("/api/auth/**").permitAll()
////                .antMatchers("/register","/remove/**").hasRole("MANAGER")
////                .antMatchers("/edit/**").hasAnyRole("MANAGER","COMANAGER")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(
////                            (request, response, authException) ->{
////                                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"); // you can implement it using lambada expression or you can create a separate class and configure it there
////                            }
//                        authenticationEntryPoint
//                )
//                .accessDeniedHandler(accessDeniedHandler)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }


}
