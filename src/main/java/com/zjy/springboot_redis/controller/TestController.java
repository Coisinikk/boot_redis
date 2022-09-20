package com.zjy.springboot_redis.controller;

import com.zjy.springboot_redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/setRedisUtils")
public class TestController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/getName")
    public Map<String,Object> getName(@RequestParam Map<String,Object> param){
        Map<String,Object> map = new HashMap<>();
        map.put("name",redisUtil.get(param.get("name").toString()));
        return map;
    }
    @GetMapping("/setName")
    public Object setName(@RequestParam Map<String,Object> param){
        String nameKey = param.get("nameKey").toString();
        String nameValue = param.get("nameValue").toString();
        redisUtil.set(nameKey,nameValue);
        return "加入成功!";
    }
}
