package com.anand.rest.webservices.restfulwebservices.user.jpa;

import com.anand.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
