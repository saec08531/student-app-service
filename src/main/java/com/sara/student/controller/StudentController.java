package com.sara.student.controller;

import com.sara.student.dto.StudentDto;
import com.sara.student.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
                this.studentService = studentService;
        }

        @GetMapping
        public String display(){
                return "Hello World";
        }

        @GetMapping("/students")
        public List<StudentDto> getStudents(){
                return studentService.getListOfStudents();
        }
}
