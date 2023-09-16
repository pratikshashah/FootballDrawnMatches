package com.example.footballmatch.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
    
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    
    @Autowired
    private JwtRequestFilter jwtRequestFilter;
    
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeRequests()
//            .requestMatchers("/api/authenticate").permitAll() // Allow authentication endpoint
//            .requestMatchers("/api/task1").hasAnyRole("USER", "ADMIN") // Configure role-based access
//            .requestMatchers("/api/task2").hasRole("ADMIN")
//            .anyRequest().authenticated()
//            .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        
//        // Add JWT filter
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//    
    

    	    protected void configure(HttpSecurity http) throws Exception {
    	        http
    	            .authorizeRequests()
    	                .requestMatchers("/api/task1/**").hasRole("TASK1_ROLE")
    	                .requestMatchers("/api/task2/**").hasRole("TASK2_ROLE")
    	                .anyRequest().authenticated()
    	                .and()
    	            .httpBasic()
    	                .and()
    	            .csrf().disable();
    	    }

    	    @Autowired
    	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	        auth
    	            .inMemoryAuthentication()
    	                .withUser("user1").password("password").roles("TASK1_ROLE")
    	                .and()
    	                .withUser("user2").password("password").roles("TASK2_ROLE");
    	}
    
}