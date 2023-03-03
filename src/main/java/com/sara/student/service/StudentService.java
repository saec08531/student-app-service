package com.sara.student.service;

import com.sara.student.dto.StudentDto;
import com.sara.student.entity.Student;
import com.sara.student.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {


    private ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    public StudentService(ModelMapper modelMapper, StudentRepository studentRepository) {
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getListOfStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
    }
}
