package com.companypowernode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author liyue
 * @since 2023-9-25
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/get")
    public Object getRedis(){

        return redisTemplate.opsForValue().get("2");
    }

    @PostMapping("/put/{value}")
    public void putRedis(@PathVariable("value") String d){
        redisTemplate.opsForValue().set(d,"lll");
    }
}
