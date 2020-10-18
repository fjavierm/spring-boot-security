package dev.binarycoders.springbootsecurity.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            // Allow all actuator endpoints
            .requestMatchers(EndpointRequest.toAnyEndpoint())
            .permitAll()
            
            // Anything else needs to be authenticated
            .antMatchers("/**")
            .authenticated()

            // Mechanism is basic authentication
            .and()
            .httpBasic();
    }
}
