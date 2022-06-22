package com.fourtitude.product.controller;

import java.util.List;
import java.util.Optional;

import com.fourtitude.product.exception.RecordNotFoundException;
import com.fourtitude.product.model.StudentEntity;
import com.fourtitude.product.service.StudentService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService service;

    // Get all students
    @GetMapping("/students")
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        return ResponseEntity.ok().body(service.getAllStudents());
    }

    // Get single student
    @RequestMapping(value="/student", method = RequestMethod.GET)
    public StudentEntity getStudent(@RequestParam("id") Long id) throws RecordNotFoundException {
        return service.getStudentById(id);
    }

    // Add new student
    @PostMapping("/student")
    public String createOrUpdateStudent(StudentEntity student) {
        System.out.println("controller - createOrUpdateStudent");
        service.createOrUpdateStudent(student);
        return "add-edit-product";
    }

    // Update existing student
    @RequestMapping(value="/student", method = RequestMethod.PUT)
    public String editStudentById(Model model, @RequestParam("id") Optional<Long> id)
            throws RecordNotFoundException {

        System.out.println("controller - editStudentById : " + id);
        if (id.isPresent()) {
            StudentEntity entity = service.getStudentById(id.get());
            service.createOrUpdateStudent(entity);
            model.addAttribute("student", entity);
        } else {
            model.addAttribute("student", new StudentEntity());
        }

        return "add-edit-student";
    }

    // Delete student
    @DeleteMapping("/student/{id}")
    public String deleteStudentById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException {

        System.out.println("controller - deleteStudentById : " + id);

        service.deleteStudentById(id);
        return "Student deleted!";
    }
}
