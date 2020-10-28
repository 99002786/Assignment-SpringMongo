package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.exception.StudentNotFoundException;
import com.student.model.Student;


@Service
public interface StudentService {
	
	Student addStudent(Student student);

    boolean deleteStudent(int stid) throws StudentNotFoundException; 

    Student getStudentById(Integer stid) throws StudentNotFoundException;
    List<Student> getAllStudents();

    List<Student> getStudentByCity(String city) throws StudentNotFoundException;
    List<Student> getStudentByDept(String dept) throws StudentNotFoundException;
//    List<Student> findByAge(Integer age) throws StudentNotFoundException;




}
