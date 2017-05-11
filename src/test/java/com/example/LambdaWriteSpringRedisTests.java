package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.handler.ExampleRequestHandler;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;


public class LambdaWriteSpringRedisTests {
	Map<String,String> input;
	
	    @Test
	    public void testHandle() {
	    	final MainHandler handler= new MainHandler();
	    	input = new HashMap<String,String>();
	    	input.put("msg", "Hi There!! This is a hello msg");
	        final Object response = handler.handleRequest(input, null);
	        assertThat(response).isNotNull();
	    }	

}
