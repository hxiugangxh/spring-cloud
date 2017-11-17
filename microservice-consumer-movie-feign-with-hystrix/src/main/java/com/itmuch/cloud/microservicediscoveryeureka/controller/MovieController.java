package com.itmuch.cloud.microservicediscoveryeureka.controller;

import com.itmuch.cloud.microservicediscoveryeureka.entity.User;
import com.itmuch.cloud.microservicediscoveryeureka.feign.UserFeignClient;
import org.bouncycastle.operator.MacCalculatorProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable("id") Long id) {
        String str = "我是测试的内容";
        System.out.println("str = " + str);

        return this.userFeignClient.findById(id);
    }

    @GetMapping("/mysimple")
    public User test(User user) {

        System.out.println("username = " + user.getUsername());

        return this.userFeignClient.findByName(user.getId(), user.getUsername(), user.getName());
    }

    @GetMapping("/user")
    public User user(User user) {

        System.out.println("id = " + user.getId());

        return this.userFeignClient.testPost(user);
    }

    @GetMapping("/test")
    public User testPost(User user) {

        Map<String, Object> map = new HashMap<>();

        map.put("id", user.getId());
        map.put("username", user.getUsername());
        map.put("name", user.getName());

        System.out.println("id = " + user.getId());

        return this.userFeignClient.testMap(map);
    }
}
