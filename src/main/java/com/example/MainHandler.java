package com.example;

import com.example.Wrapper.SpringRequestHandler;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainHandler extends SpringRequestHandler<Map<String,String>, Object> {

    /**
     * Here we create the Spring {@link ApplicationContext} that will
     * be used throughout our application.
     */
    private static final ApplicationContext context =
            new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

   // @Override
    public ApplicationContext getApplicationContext() {
    	System.out.println("This is main handler... getting application context");
        return context;
    }
}
