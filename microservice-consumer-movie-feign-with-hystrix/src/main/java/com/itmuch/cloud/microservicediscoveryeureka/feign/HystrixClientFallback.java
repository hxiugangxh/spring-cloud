package com.itmuch.cloud.microservicediscoveryeureka.feign;

import com.itmuch.cloud.microservicediscoveryeureka.entity.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HystrixClientFallback implements UserFeignClient {

    @Override
    public User findById(Long id) {
        User user = new User();

        user.setId(-1L);
        user.setName("这是fallback");

        return user;
    }

    @Override
    public User testPost(User user) {
        user = new User();
        user.setId(0L);
        return user;
    }

    public User findByName(Long id, String username, String name) {
        User user = new User();
        user.setId(0L);
        return user;
    }

    @Override
    public User testMap(Map<String, Object> map) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}