package com.maventemp;

import com.maventemp.dao.StudentDao;
import com.maventemp.daoimpl.StudentDaoImpl;
import com.maventemp.entity.Student;

public class App {

    public static void main(String[] args) {

        StudentDao studentDao = new StudentDaoImpl();

        // creating a student
        Student student1 = new Student(1,"Dipesh","Singh",689);
        Student student2 = new Student(1,"Harshil","Kalsariya",685);
        Student student3 = new Student(1,"Rahul","Mewada",589);

        // saving student
        studentDao.saveStudent(student1);
        studentDao.saveStudent(student2);
        studentDao.saveStudent(student3);

        // change in state of object
        student1.setFirstName("Shivay");

        // saving update student
        studentDao.updateStudent(student1);

        // get student
        System.out.println(studentDao.getStudentById(1));

        // get all students
        studentDao.getAllStudents().forEach(System.out::println);

        // delete student
        studentDao.deleteStudent(1);

    }

}
