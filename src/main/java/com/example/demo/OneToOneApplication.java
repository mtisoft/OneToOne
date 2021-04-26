package com.example.demo;

import com.example.demo.model.Instructor;
import com.example.demo.model.InstructorDetail;
import com.example.demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneApplication{// implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

//	@Autowired
//	InstructorRepository instructorRepository;
//
//	@Override
//	public void run(String...args) throws Exception {
//
//		Instructor instructor = new Instructor("IDRICE","MOUPI","mtisoft1@gmail.com");
//
//		InstructorDetail instructorDetail = new InstructorDetail("welcome software","enjoying");
//
//		instructor.setInstructorDetail(instructorDetail);
//
//		instructorRepository.save(instructor);
//	}

}
