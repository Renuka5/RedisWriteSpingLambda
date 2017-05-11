package com.example.service;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisException;

public class RedisService {
	public String readRedis() {
	RestTemplate restTemplate = new RestTemplate();
	//API endpoint url for Lambda function
	String readUrl ="API_GW_URL";
	
    //Call to the Lambda function performing read on Redis    	
	String response = restTemplate.getForObject(readUrl, String.class, "Employee");
	System.out.println("Read Output:" + response);
	return response;		
}


public void addHash(Map<String, String> input, JedisPool pool) {
    //adding some values in Redis HASH
	String key = "Employee";

    Jedis jedis = pool.getResource();
    
    try {
    	
        //save to redis
        jedis.hmset(key, input);

        //setting TTL for the key
        jedis.expire(key, 300);
        
        
    } catch (JedisException e) {
        //return Jedis instance to the pool
        if (null != jedis) {
            pool.returnBrokenResource(jedis);
            jedis = null;
        }
    } finally {
        ///return Jedis instance to the pool
        if (null != jedis)
            pool.returnResource(jedis);
    }
}}
