package com.fourtitude.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studentmatric")
    private String studentmatric;

    @Column(name = "studentname")
    private String studentname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentMatric() {
        return studentmatric;
    }

    public void setStudentMatric(String studentmatric) {
        this.studentmatric = studentmatric;
    }

    public String getStudentName() {
        return studentname;
    }

    public void setStudentName(String studentname) {
        this.studentname = studentname;
    }

}
