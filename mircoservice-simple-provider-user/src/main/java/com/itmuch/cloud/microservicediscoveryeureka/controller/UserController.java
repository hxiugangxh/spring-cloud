package com.itmuch.cloud.microservicediscoveryeureka.controller;

import com.google.common.collect.Lists;
import com.itmuch.cloud.microservicediscoveryeureka.entity.User;
import com.itmuch.cloud.microservicediscoveryeureka.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("eurekaClient")
    private EurekaClient eurekaClient;

    @Autowired
    @Qualifier("discoveryClient")
    private DiscoveryClient discoveryClient;

    @GetMapping("/mysimple")
    public User test(@RequestParam("id") Long id, @RequestParam("username") String username, @RequestParam("name")
            String name) {
        User user = new User();

        user.setId(id);
        user.setUsername(username);
        user.setName(name);

        return user;
    }

    @GetMapping("/testMap")
    public User testMap(@RequestParam Map<String, Object> map) {
        User user = new User();

        user.setId(Long.parseLong(map.get("id") + ""));
        user.setUsername(map.get("username") + "");
        user.setName(map.get("name") + "");

        return user;
    }

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable("id") Long id) {
        User user = new User();

        user.setName(id + "");
        return user;
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        return user;
    }

    // 该请求不会成功
    @GetMapping("/get-user")
    public User getUser(User user) {
        return user;
    }

    @GetMapping("list-all")
    public List<User> listAll() {
        ArrayList<User> list = Lists.newArrayList();
        User user = new User(1L, "zhangsan");
        User user2 = new User(2L, "zhangsan");
        User user3 = new User(3L, "zhangsan");
        list.add(user);
        list.add(user2);
        list.add(user3);
        return list;

    }
}
