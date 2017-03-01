package com.shc.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * A class is responsible for initialization of a spring-boot application.
 *
 * @author created: akowalczyk on 2017-02-27 13:35
 * @author last change: $Author: $ on $Date: $
 * @version $Revision: $
 */
@SpringBootApplication
public class TestApplication extends SpringBootServletInitializer
{
    public static void main( String[] args )
    {
        SpringApplication.run( TestApplication.class, args );
    }

    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application )
    {
        return application.sources( TestApplication.class );
    }
}
