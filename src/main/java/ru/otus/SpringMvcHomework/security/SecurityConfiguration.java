package ru.otus.SpringMvcHomework.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("adminPass").roles("ADMIN")
                .and()
                .withUser("user1").password(passwordEncoder().encode("userPass")).roles("USER");
        ;
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                //.antMatchers("/user1/**").hasRole("USER")
                .antMatchers("/books/showAll/").anonymous()
                .and()
                .authorizeRequests()
                .antMatchers("/books/newBook").authenticated()
                //  .antMatchers("/login*").permitAll()
                // .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .anonymous()
                .principal("anonymous")
                .and()
                .rememberMe().key("Some secret")
        ;
    }

        //form login and logout:
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/showAll.html", true)
//                .failureUrl("/login.html?error=true");




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/")
                .antMatchers( "/static/**" );
    }
}
