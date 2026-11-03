package com.sathish.demo.config;
import com.sathish.demo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.*; import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.*; import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig {
 private final JwtAuthenticationFilter jwtFilter; private final UserDetailsService userDetailsService;
 public SecurityConfig(JwtAuthenticationFilter f,UserDetailsService u){jwtFilter=f;userDetailsService=u;}
 @Bean public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean public AuthenticationProvider authenticationProvider(){DaoAuthenticationProvider p=new DaoAuthenticationProvider();p.setUserDetailsService(userDetailsService);p.setPasswordEncoder(passwordEncoder());return p;}
 @Bean public AuthenticationManager authenticationManager(AuthenticationConfiguration c)throws Exception{return c.getAuthenticationManager();}
 @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
  http.csrf(csrf->csrf.disable()).sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
   .authenticationProvider(authenticationProvider()).authorizeHttpRequests(a->a
    .requestMatchers("/auth/**","/students/register","/swagger-ui/**","/v3/api-docs/**","/actuator/health").permitAll()
    .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated())
   .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
  return http.build();
 }
}
