package com.sara.student.controller;

import com.sara.student.dto.StudentDto;
import com.sara.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/")
public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
                this.studentService = studentService;
        }

        @GetMapping
        public String display() {
                return "Hello World";
        }

        @GetMapping("/students")
        public List<StudentDto> getStudents() {
                return studentService.getListOfStudents();
        }

        @PostMapping
        public void uploadStudent(@RequestPart(value = "file", required = false) MultipartFile file, @RequestPart StudentDto studentDto) {
                log.info("Inside upload student method");
                log.info("Student: {}", studentDto);
        }
}
