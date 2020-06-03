package com.example.demo.api;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/student")
@RestController
@CrossOrigin("*")

public class StudentController {
    private final StudentService StudentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.StudentService = studentService;
    }
    @PostMapping
    public void addstudent(@RequestBody StudentModel student){
        this.StudentService.addstudent(student);
    }
    @GetMapping("/")
    public List<StudentModel> showstudent(){
        List<StudentModel> AllStudent = this.StudentService.showstudent();
        return AllStudent;
    }
    @GetMapping("/test")
    public String testsend(){
        String test = this.StudentService.testsend();
        return test;
    }
    @DeleteMapping("/delete/{id}")
    public void deletestudent(@PathVariable("id") UUID id){
        this.StudentService.deletestudent(id);
    }
}
