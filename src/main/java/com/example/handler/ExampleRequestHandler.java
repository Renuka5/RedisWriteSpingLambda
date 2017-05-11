package com.example.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.service.RedisService;

import redis.clients.jedis.JedisPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;


@Component
public class ExampleRequestHandler implements RequestHandler<Map<String,String>, Object> {

    private final RedisService redisService;

    /**
     * Dependency injection is handled via autowiring!
     */
    @Autowired
    public ExampleRequestHandler(final RedisService redisService) {
    	System.out.println("This is constructor call for ex handler");
        this.redisService = Objects.requireNonNull(redisService, "exampleServiceA");
        
    }

    //@Override
    public Object handleRequest(final Map<String,String> input, final Context context) {

	    //address of redis server
		final String redisHost = "localhost";
				
		final Integer redisPort = 6379;
	 
	    //the jedis connection pool..
	   //configure our pool connection
	    JedisPool pool = new JedisPool(redisHost, redisPort);
	    
	    //Add the input to Redis
	    redisService.addHash(input,pool);
        
        //Read the value from Redis and return
		return redisService.readRedis();
	
    }
}
