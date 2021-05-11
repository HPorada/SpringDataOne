package com.example.springdataone.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.name, u.password, 1 FROM user u WHERE u.name=?")
                .authoritiesByUsernameQuery("SELECT u.name, u.role, 1 FROM user u WHERE u.name=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic().and().authorizeRequests()

                .antMacthers(HttpMethod.GET, "/api/product").hasRole("ROLE_CUSTOMER", "ROLE_ADMIN")
                .antMacthers(HttpMethod.GET, "/api/product/all").hasRole("ROLE_CUSTOMER", "ROLE_ADMIN")
                .antMacthers(HttpMethod.GET, "/api/order").hasRole("ROLE_CUSTOMER", "ROLE_ADMIN")
                .antMacthers(HttpMethod.GET, "/api/order/all").hasRole("ROLE_CUSTOMER", "ROLE_ADMIN")
                .antMacthers(HttpMethod.POST, "/api/order").hasRole("ROLE_CUSTOMER", "ROLE_ADMIN")

                .antMacthers(HttpMethod.GET, "/api/customer").hasRole("ROLE_CUSTOMER")
                .antMacthers(HttpMethod.GET, "/api/customer/all").hasRole("ROLE_CUSTOMER")

                .antMacthers(HttpMethod.POST, "/api/admin/product").hasRole("ROLE_ADMIN")
                .antMacthers(HttpMethod.PUT, "/api/admin/product").hasRole("ROLE_ADMIN")
                .antMacthers(HttpMethod.PATCH, "/api/admin/product").hasRole("ROLE_ADMIN")

                .antMacthers(HttpMethod.POST, "/api/admin/customer").hasRole("ROLE_ADMIN")
                .antMacthers(HttpMethod.PUT, "/api/admin/customer").hasRole("ROLE_ADMIN")
                .antMacthers(HttpMethod.PATCH, "/api/admin/customer").hasRole("ROLE_ADMIN")

                .antMacthers(HttpMethod.PUT, "/api/admin/oder").hasRole("ROLE_ADMIN")
                .antMacthers(HttpMethod.PATCH, "/api/admin/order").hasRole("ROLE_ADMIN")

                .and().formLogin().permitAll()
                .and().logout().permitAll()
                .and().csrf().disable();
    }
}
