package com.example.microservices.repository;

import com.example.microservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById( int id);
}
