package com.maventemp.dao;

import com.maventemp.entity.Student;

import java.util.List;

public interface StudentDao {

    void saveStudent(Student student);

    void updateStudent(Student student);

    Student getStudentById(long id);

    List<Student> getAllStudents();

    void deleteStudent(long id);

}
