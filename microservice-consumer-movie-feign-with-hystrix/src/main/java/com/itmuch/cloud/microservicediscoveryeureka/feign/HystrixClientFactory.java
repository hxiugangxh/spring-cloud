package com.itmuch.cloud.microservicediscoveryeureka.feign;

import com.itmuch.cloud.microservicediscoveryeureka.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        HystrixClientFactory.LOGGER.info("fallback; reason was: {}", cause.getMessage());

        return new UserFeignClient() {
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                return user;
            }

            @Override
            public User testPost(User user) {
                return null;
            }

            @Override
            public User findByName(Long id, String username, String name) {
                return null;
            }

            @Override
            public User testMap(Map<String, Object> map) {
                return null;
            }
        };
    }
}
