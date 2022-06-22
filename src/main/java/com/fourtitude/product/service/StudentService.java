package com.fourtitude.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fourtitude.product.exception.RecordNotFoundException;
import com.fourtitude.product.model.StudentEntity;
import com.fourtitude.product.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository;

	public List<StudentEntity> getAllStudents() {
		System.out.println("service - getAllStudents");
		List<StudentEntity> result = (List<StudentEntity>) repository.findAll();

		if (result.size() > 0) {
			return result;
		} else {
			return new ArrayList<StudentEntity>();
		}
	}

	public StudentEntity getStudentById(Long id) throws RecordNotFoundException {
		System.out.println("service - getStudentById");
		Optional<StudentEntity> student = repository.findById(id);
		boolean exist = repository.existsById(id);

		if (!exist) {
			throw new RecordNotFoundException("No product record exist for given id: " + id + "!");
		}

		return student.get();
	}

	public StudentEntity createOrUpdateStudent(StudentEntity entity) {
		System.out.println("service - createOrUpdateStudent");
		// Create new entry
		if (entity.getId() == null) {
			entity = repository.save(entity);

			return entity;
		} else {
			// update existing entry
			Optional<StudentEntity> student = repository.findById(entity.getId());

			if (student.isPresent()) {
				StudentEntity newEntity = student.get();
				newEntity.setStudentMatric(entity.getStudentMatric());
				newEntity.setStudentName(entity.getStudentName());

				newEntity = repository.save(newEntity);

				return newEntity;
			} else {
				entity = repository.save(entity);

				return entity;
			}
		}
	}

	public void deleteStudentById(Long id) throws RecordNotFoundException {
		System.out.println("service - deleteStudentById");

		Optional<StudentEntity> student = repository.findById(id);

		if (student.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No product record exist for given id: " + id + "!");
		}
	}
}
