package com.akashcodez.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsLoader userDetailsLoader;

    @Autowired
    private JWTAthenticationEntryPoint jwtAthenticationEntryPoint;

    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    AuthenticationProvider getAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsLoader);
        return daoAuthenticationProvider;
    }


    @Bean
    public SecurityFilterChain mySecurityConfig(HttpSecurity http)throws Exception{

        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers("/app/**","/auth/**").permitAll()
//                        .antMatchers("/admin/**").hasAuthority("ADMIN")
//                        .antMatchers("/user/**").hasAuthority("USER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()).csrf().disable()
                .exceptionHandling().authenticationEntryPoint(jwtAthenticationEntryPoint);
//                .formLogin(Customizer.withDefaults()).csrf().disable()      //for browser

        http
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(getAuthenticationProvider())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }


    @Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}