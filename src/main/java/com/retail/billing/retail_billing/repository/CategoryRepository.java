package com.retail.billing.retail_billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.billing.retail_billing.entity.CategoryEntity;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>{
     Optional<CategoryEntity> findByCategoryId(String categoryId);

}
