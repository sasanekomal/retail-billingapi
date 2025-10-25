package com.retail.billing.retail_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.billing.retail_billing.entity.UserEntity;

import java.util.Optional;




public interface UserRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUserId(String userId);
}
