package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exception.DateOfBirthException;
import com.example.demo.repository.ImagInnovateRepository;

@Service
public class ImagInnovateService {

	@Autowired
	ImagInnovateRepository imagInnovateRepository;

	public ResponseEntity<Object> saveStudent(Student student) {

		Date dob = student.getDob();
		Date currentDate = new Date();
		long difference_In_Time = currentDate.getTime() - dob.getTime();

		long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));

		student.setTotalMarks(student.getMarks1() + student.getMarks2() + student.getMarks3());
		student.setAverage(student.getTotalMarks() / 3);
		if (student.getAverage() > 35) {
			student.setResult("PASS");
		} else {
			student.setResult("FAIL");
		}
		if (difference_In_Years > 15 && difference_In_Years <= 20) {
			Student student1 = imagInnovateRepository.saveAndFlush(student);
			return new ResponseEntity<>(student1, HttpStatus.OK);
		} else {
			throw new DateOfBirthException();
		}
	}

//	public Student updateStudentMarksBasedOnId1(int marks1,int marks2,int marks3,long id) {
//		Student student=imagInnovateRepository.getById(id);
//		student.setMarks1(marks1);
//		student.setMarks2(marks2);
//		student.setMarks3(marks3);
//		student.setTotalMarks(student.getMarks1()+student.getMarks2()+student.getMarks3());
//		student.setAverage(student.getTotalMarks()/3);
//		if(student.getAverage()>35) {
//			student.setResult("PASS");
//		}else {
//			student.setResult("FAIL");
//		}
//		return imagInnovateRepository.saveAndFlush(student);
//		
//	}

	public Student updateStudentMarksBasedOnId(Student student1) {
		Student student = imagInnovateRepository.getById(student1.getId());
		student.setMarks1(student1.getMarks1());
		student.setMarks2(student1.getMarks2());
		student.setMarks3(student1.getMarks3());
		student.setTotalMarks(student.getMarks1() + student.getMarks2() + student.getMarks3());
		student.setAverage(student.getTotalMarks() / 3);
		if (student.getAverage() > 35) {
			student.setResult("PASS");
		} else {
			student.setResult("FAIL");
		}
		return imagInnovateRepository.saveAndFlush(student);

	}

}
