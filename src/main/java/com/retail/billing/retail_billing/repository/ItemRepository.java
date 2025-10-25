package com.retail.billing.retail_billing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.billing.retail_billing.entity.ItemEntity;



public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

    Optional<ItemEntity> findByItemId(String id);

    Integer countByCategoryId(Long id);


}
