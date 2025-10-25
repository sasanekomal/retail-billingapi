package com.retail.billing.retail_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.billing.retail_billing.entity.OrderItemEntity;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity, Long>{

}
