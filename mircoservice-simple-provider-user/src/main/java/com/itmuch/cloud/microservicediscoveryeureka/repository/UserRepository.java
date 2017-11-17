package com.itmuch.cloud.microservicediscoveryeureka.repository;

import com.itmuch.cloud.microservicediscoveryeureka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
