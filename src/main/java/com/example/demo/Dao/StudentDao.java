package com.example.demo.Dao;

import com.example.demo.model.StudentModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDao {
    int insertstudent(UUID id, StudentModel student);
    default int insertstudent(StudentModel student){
        UUID id = UUID.randomUUID();
        return insertstudent(id,student);
    }
    List<StudentModel> showstudent();

    void deletestudent(UUID id);

    String testsend();
}
