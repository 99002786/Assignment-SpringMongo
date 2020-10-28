package com.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.exception.StudentNotFoundException;
import com.student.model.Student;
import com.student.service.StudentService;

@RequestMapping("/student-api")
@RestController
public class StudentResponseController {
	@Autowired
	StudentService studentService;
	@PostMapping("/students")
    ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student nstudent = studentService.addStudent(student);
        return ResponseEntity.ok(nstudent);
    }
    @DeleteMapping("/students/delete-one/{stid}")
    ResponseEntity<Void> deleteStudent(@PathVariable("stid")Integer stid) throws StudentNotFoundException{
        studentService.deleteStudent(stid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/students/get-one/{stid}")
    ResponseEntity<Student> getStudentById(@PathVariable("stid")Integer stid) throws StudentNotFoundException{
        Student nstudent = studentService.getStudentById(stid);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Getting student by Id");
        header.add("title", "One Student");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(header).body(nstudent);
    }
    
    @GetMapping("/students")
    ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList =  studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }
    @GetMapping("/students/city/{city}")
    ResponseEntity<List<Student>> getStudentbyCity(@PathVariable("city")String city) throws StudentNotFoundException{
        List<Student> studentList =   studentService.getStudentByCity(city);
        return ResponseEntity.ok(studentList);
    }
    @GetMapping("/students/department/{department}")
    ResponseEntity<List<Student>> getStudentbycategory(@PathVariable("dept")String dept)throws StudentNotFoundException{
        List<Student> studentList = studentService.getStudentByDept(dept);    
        return ResponseEntity.ok(studentList);
    }

}
