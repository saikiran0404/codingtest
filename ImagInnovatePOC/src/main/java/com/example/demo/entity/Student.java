package com.example.demo.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Range;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@ComponentScan("com.example.demo.entity")
@Entity
@Table
public class Student implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@Size(min=3,message="FirstName should be greater then 3 Characters")
	private String firstName;
	
	@Column
	@Size(min=3,message="LastName should be greater then 3 Characters")
	private String lastName;
	
	@Column
	//@Size(min=16,max=20,message="Age should be greater than 15 and less than 20")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dob;
	
	@Column
	@Pattern(regexp = "^[A-C]*${1}",message="Section should be only cahracters between A to C")
	@Size(max=1,message="Section should be a single Characters between A to C")
	private String section;
	
	@Column
	@Pattern(regexp = "^[M,F]*$",message="Gender should be single cahracters either M for Male or F for Female")
	@Size(max=1,message="Gender should be single cahracters either M for Male or F for Female")
	private String gender;
	
	@Column
	@NotNull
	@Range(min=0,max=100,message="Marks1 should be between 0 to 100")
	private Integer marks1;
	
	@Column
	@NotNull
	@Range(min=0,max=100,message="Marks2 should be between 0 to 100")
	private int marks2;
	
	@Column
	@NotNull
	@Range(min=0,max=100,message="Marks3 should be between 0 to 100")
	private int marks3;
	
	private int totalMarks;
	private int average;
	private String result;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getAverage() {
		return average;
	}
	public void setAverage(int average) {
		this.average = average;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	

}
