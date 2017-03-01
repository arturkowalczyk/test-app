package com.shc.testapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * A security configuration for a test application.
 *
 * @author created: akowalczyk on 2017-02-27 13:36
 * @author last change: $Author: $ on $Date: $
 * @version $Revision: $
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure( HttpSecurity http ) throws Exception
    {
        http
            .authorizeRequests()
                .anyRequest().hasRole( "ISPN" )
                .and()
            .headers()
                .frameOptions().sameOrigin(); // an application can be started in a iframe
    }
}
