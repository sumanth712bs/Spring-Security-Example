package io.badadal.sumanth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sbadadal
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}adminPassword").roles("APP-ADMIN")
                .and()
                .withUser("user").password("{noop}testPassword").roles("APP-USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/inMemory/test")
                .hasRole("APP-ADMIN")
                .antMatchers("/inMemory/hello").hasRole("APP-USER")
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

}
