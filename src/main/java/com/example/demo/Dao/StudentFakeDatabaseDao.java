package com.example.demo.Dao;

import com.example.demo.model.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class StudentFakeDatabaseDao implements StudentDao{

    private final JdbcTemplate JdbcTemplate;

    @Autowired
    public StudentFakeDatabaseDao(JdbcTemplate jdbcTemplate) {
        JdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertstudent(UUID id, StudentModel student) {
        final String sql = "INSERT INTO student VALUES (?,?)";
        JdbcTemplate.update(sql,id,student.getName());
        return 1;
    }

    @Override
    public List<StudentModel> showstudent() {
        final String sql = "SELECT * FROM student";
        List<StudentModel> Allstudent = JdbcTemplate.query(sql,((resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new StudentModel(id,name);
        }));
        return Allstudent;
    }

    @Override
    public void deletestudent(UUID id) {
        final String sql = "DELETE FROM student WHERE id = ?";
        JdbcTemplate.update(sql,id);
    }

    @Override
    public String testsend() {
        return "Hello";
    }
}
