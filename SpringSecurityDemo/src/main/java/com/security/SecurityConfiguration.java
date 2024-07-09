package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.security.model.MyUserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private MyUserService myUserService;
	
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//        		.csrf(AbstractHttpConfigurer::disable)
//            .authorizeHttpRequests(auth -> {
//                auth.requestMatchers("/home","register/**").permitAll();
//                auth.requestMatchers("/admin/**").hasRole("ADMIN");
//                auth.requestMatchers("/user/**").hasRole("USER");
//                auth.anyRequest().authenticated();
//            })
////            httpSecurityFormLoginConfigurer
//            .formLogin(httpSecurityFormLoginConfigurer ->{
//            	httpSecurityFormLoginConfigurer.loginPage("/login")
//            	.successHandler(new AuthenticationSuccessHandler())
//            	.permitAll();
//            })
//            .build();
//    }
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            // Disable CSRF for simplicity, but consider enabling it in production.
            .csrf(AbstractHttpConfigurer::disable)
            
            // Define URL-based authorization rules.
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/home", "/register/**").permitAll(); // Allow access to home and register pages without authentication.
                auth.requestMatchers("/admin/**").hasRole("ADMIN"); // Only ADMIN role can access /admin/**.
                auth.requestMatchers("/user/**").hasRole("USER"); // Only USER role can access /user/**.
                auth.anyRequest().authenticated(); // All other requests require authentication.
            })
            
            // Configure form-based login.
            .formLogin(formLogin -> {
                formLogin
                    .loginPage("/login") // Custom login page URL.
                    .defaultSuccessUrl("/dashboard", true) // Redirect to /dashboard on successful login.
                    .failureUrl("/login?error=true") // Redirect to /login with an error parameter on login failure.
                    .permitAll(); // Allow all users to access the login page.
            })
            
            // Configure logout.
            .logout(logout -> {
                logout
                    .logoutUrl("/logout") // Custom logout URL.
                    .logoutSuccessUrl("/home") // Redirect to home page on successful logout.
                    .permitAll(); // Allow all users to access the logout URL.
            });
        
        // Build the SecurityFilterChain.
        return httpSecurity.build();
    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails normalUser = User.builder()
//            .username("user")
//            .password("$2a$12$c5RoOI0MCHXLNuaK4r0uPeSjsaGgfDpiYWAwa4vvegf924BUJgbFW")
//            .roles("USER")
//            .build();
//
//        UserDetails adminUser = User.builder()
//            .username("admin")
//            .password("$2a$12$hMElhlDqqA.WcxoqhUx0/uK28VW2/Ra5LofMEhCWYpKmGvRnEV0Gy")
//            .roles("ADMIN","USER")
//            .build();
//
//        return new InMemoryUserDetailsManager(normalUser, adminUser);
//    }
    
    @Bean
    public UserDetailsService userDetailsService() {
    	return myUserService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    provider.setUserDetailsService(myUserService);
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
