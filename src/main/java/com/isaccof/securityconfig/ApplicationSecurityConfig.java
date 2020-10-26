package com.isaccof.securityconfig;

import com.isaccof.authentication.ApplicationUserService;
import com.isaccof.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private
    JwtFilter jwtFilter;

    @Bean
    public UserDetailsService userDetailsService() {

        return new ApplicationUserService();

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

        daoAuthenticationProvider.setUserDetailsService(userDetailsService());

        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());

        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* bASIC AUTHENTICATION BY ROLE     */
        /*http.csrf().disable().
                authorizeRequests()
                .antMatchers("/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
                .antMatchers(HttpMethod.POST,"/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
                .anyRequest().authenticated().and().httpBasic();*/
                //.and()
               // .formLogin().permitAll()
               // .and()
               // .logout().permitAll();

        //bASIC AUTHENTICATION BY  PERMISSION

       /* http.csrf().disable().
                authorizeRequests()
                .antMatchers("/api/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
                .antMatchers(HttpMethod.POST,"/api/**").hasAuthority(USERS_WRITE.getPermission())
                .anyRequest().authenticated().and().httpBasic();
*/

        //JWT AUTHENTICATION


        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/user/*").hasRole("USER")
                .antMatchers("/register", "/auth").permitAll()
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

