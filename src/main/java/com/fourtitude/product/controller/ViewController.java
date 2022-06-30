package com.fourtitude.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String viewStudents() {
       return "list-students";
    }

    @RequestMapping("/add-student")
    public String addStudent() {
        return "add-edit-student";
    }

    @RequestMapping(value = "/edit-student", params = "id")
    public String editStudent() {
        return "add-edit-student";
    }
}
