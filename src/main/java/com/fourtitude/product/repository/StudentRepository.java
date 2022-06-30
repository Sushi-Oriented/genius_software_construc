package com.fourtitude.product.repository;

import com.fourtitude.product.model.StudentEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long>{
    
}
