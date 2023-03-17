package com.sara.student.controller;

import com.sara.student.dto.StudentDto;
import com.sara.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
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
    public void uploadStudent(@RequestPart(value = "file", required = false) MultipartFile file,
                              @RequestPart StudentDto studentDto) throws FileNotFoundException {
        log.info("Inside upload student method");
        log.info("Student: {}", studentDto);
        if (file.isEmpty()) throw new FileNotFoundException();
        List<String> list = processFile(file);
        list.forEach(System.out::println);
    }

    private List<String> processFile(MultipartFile multipartFile) {
        BufferedReader br;
        List<String> result = new ArrayList<>();
        try {
            String line;
            InputStream is = multipartFile.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            log.error("Error while reading the file", e);
        }
        return result;
    }
}
