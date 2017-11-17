package com.itmuch.cloud.microservicediscoveryeureka.feign;

import com.itmuch.cloud.microservicediscoveryeureka.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@FeignClient(name = "microservice-simple-provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    User testPost(@RequestBody User user);

    @RequestMapping(value = "/mysimple", method = RequestMethod.GET)
    public User findByName(@RequestParam("id") Long id, @RequestParam("username") String username, @RequestParam
            ("name") String name);

    @RequestMapping(value = "/testMap", method = RequestMethod.GET)
    User testMap(@RequestParam Map<String, Object> map);
}
