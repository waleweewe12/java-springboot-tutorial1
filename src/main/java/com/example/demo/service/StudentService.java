package com.example.demo.service;

import com.example.demo.Dao.StudentDao;
import com.example.demo.model.StudentModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(@Qualifier("postgres") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int addstudent(StudentModel student) {
        return studentDao.insertstudent(student);
    }

    public List<StudentModel> showstudent(){
        return studentDao.showstudent();
    }

    public String testsend(){
        return studentDao.testsend();
    }

    public void deletestudent(UUID id){
        studentDao.deletestudent(id);
    }
}
