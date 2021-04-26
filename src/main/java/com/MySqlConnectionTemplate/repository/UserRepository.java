package com.MySqlConnectionTemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MySqlConnectionTemplate.model.domain.jpaEntities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository < UserEntity, Long > {
    UserEntity findByEmail(String email);
}
