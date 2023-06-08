package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//searchByLastName(studentDAO);
			
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		myStudent.setFirstName("John");
		System.out.println("Updating student ...");
		studentDAO.update(myStudent);

		System.out.println(myStudent);
	}

	private void searchByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(2));
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John","Doe","john@liv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@liv2code.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@liv2code.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student. Generated ids: " + tempStudent1.getId() + " " +  tempStudent2.getId() + " " +tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Maksym","Milian","miliancode@gmail.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
