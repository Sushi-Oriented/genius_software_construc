package com.fourtitude.product.repository;

import com.fourtitude.product.model.ProductEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>{
    
}
