package com.oazofeifa.tcudrake.SpringConfig.Security;

import com.oazofeifa.tcudrake.Persistence.Entities.User;
import com.oazofeifa.tcudrake.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.security.crypto.keygen.StringKeyGenerator;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .debug(false)
                .ignoring()
                    .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()

                .and()
                .authorizeRequests()
                    .antMatchers("/blogs/nueva-entrada", "/blogs/publicar-entrada")
                    .hasAnyAuthority("admin","student","researcher")

                .and()
                .authorizeRequests()
                    .antMatchers("/","/inicio","/datos", "/blogs" ,"/blogs/**","/static/**").permitAll()

                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")

                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");

        /*User userNew = new User();
        userNew.setEmail("oscar.azofeifa.segura@gmail.com");
        userNew.setPassword("Segura");
        userNew.setName("Oscar");
        userNew.setLastname("Azofeifa");
        userNew.setRoleFk(1);
        userService.create(userNew);*/

    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

}
