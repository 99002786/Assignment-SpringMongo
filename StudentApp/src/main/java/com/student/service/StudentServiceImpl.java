package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentRepository;
import com.student.exception.StudentNotFoundException;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		Student newStudent = studentRepository.save(student);
		return newStudent;
	}

	@Override
	public boolean deleteStudent(int stid) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		studentRepository.deleteById(stid);
		return true;
	}

	@Override
	public Student getStudentById(Integer stid) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findById(stid)
				.orElseThrow(()-> new StudentNotFoundException("Id not available"));
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public List<Student> getStudentByCity(String city) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findByAddressCity(city);
	}

	@Override
	public List<Student> getStudentByDept(String dept) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		return studentRepository.findByDept(dept);
	}

	

}
