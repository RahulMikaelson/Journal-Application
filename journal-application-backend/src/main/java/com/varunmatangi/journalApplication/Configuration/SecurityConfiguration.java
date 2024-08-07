package com.varunmatangi.journalApplication.Configuration;

import com.varunmatangi.journalApplication.Services.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.SortedMap;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("Filter Chain Method is Invoked");
        return http
                .authorizeHttpRequests((authorizeHttp)-> authorizeHttp
                        .requestMatchers("/health-check")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .csrf((csrf)->csrf.ignoringRequestMatchers("/api/user/register"))
                .httpBasic(Customizer.withDefaults())
                .build();
    }



    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        System.out.println("This method is invoked");
        return  new ProviderManager(daoAuthenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        System.out.println("Password Encoder Bean is invoked");
        return new BCryptPasswordEncoder();
    }
}
