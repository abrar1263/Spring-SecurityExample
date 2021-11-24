package com.perfectsqaure.SpringSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index").permitAll()
                .antMatchers(HttpMethod.POST,"/api/**").hasAuthority(ApplicationUserPermission.USER_WRITE.getPermission())
                .antMatchers(HttpMethod.GET,"/api/**").hasAuthority(ApplicationUserPermission.USER_READ.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails NormalUser = User.builder()
                .username("Abrar")
                .password(passwordEncoder.encode("Ansari"))
//                .roles(ApplicationUserRole.USER.name())
                .authorities(ApplicationUserRole.USER.grantedAuthorities())
                .build();
        UserDetails AdminUser = User.builder()
                .username("Admin")
                .password(passwordEncoder.encode("Password"))
//                .roles(ApplicationUserRole.ADMIN.name())
                .authorities(ApplicationUserRole.ADMIN.grantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                NormalUser,AdminUser
        );
    }
}
