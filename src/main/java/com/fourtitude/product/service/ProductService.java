package com.fourtitude.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fourtitude.product.exception.RecordNotFoundException;
import com.fourtitude.product.model.ProductEntity;
import com.fourtitude.product.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;

	public List<ProductEntity> getAllProducts() {
		System.out.println("getAllProducts");
		List<ProductEntity> result = (List<ProductEntity>) repository.findAll();

		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<ProductEntity>();
		}
	}

	public ProductEntity getProductById(Long id) throws RecordNotFoundException {
		System.out.println("getProductById");
		Optional<ProductEntity> product = repository.findById(id);
		boolean exist = repository.existsById(id);

		if (!exist) {
			throw new RecordNotFoundException("No product record exist for given id: " + id + "!");
		}

		return product.get();
	}

	// public ProductEntity updateProduct(ProductEntity product) throws RecordNotFoundException{
    //     Optional<ProductEntity> productDb = this.repository.findById(product.getId());

    //     if (productDb.isPresent()) {
    //         ProductEntity productUpdate = productDb.get();
    //         productUpdate.setId(product.getId());
    //         productUpdate.setName(product.getName());
    //         productUpdate.setDescription(product.getDescription());
    //         repository.save(productUpdate);
    //         return productUpdate;
    //     } else {
    //         throw new RecordNotFoundException("Record not found with id : " + product.getId());
    //     }
    // }

	public ProductEntity createOrUpdateProduct(ProductEntity entity)  {
		System.out.println("createOrUpdateProduct");
		
		// Create new entry
		if (entity.getId() == null) {
			entity = repository.save(entity);

			return entity;
		} else {
			// update existing entry
			Optional<ProductEntity> product = repository.findById(entity.getId());
			System.out.println(entity);
			if (product.isPresent()) {
				ProductEntity newEntity = product.get();
				newEntity.setBrand(entity.getBrand());
				newEntity.setCategory(entity.getCategory());
				newEntity.setCode(entity.getCode());
				newEntity.setDescription(entity.getDescription());
				newEntity.setName(entity.getName());
				newEntity.setType(entity.getType());

				newEntity = repository.save(newEntity);

				return newEntity;
			} else {
				entity = repository.save(entity);

				return entity;
			}
		}
	}

	public void deleteProductById(Long id) throws RecordNotFoundException {
		System.out.println("deleteProductById");

		Optional<ProductEntity> product = repository.findById(id);

		if (product.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No product record exist for given id: " + id + "!");
		}
	}
}
