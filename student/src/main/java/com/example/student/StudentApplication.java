package com.example.student;

import com.example.student.dao.StudentDao;
import com.example.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {
@Autowired
private StudentDao studentDao;

	public static void main(String[] args)  {
		SpringApplication.run(StudentApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Student student=getStudent();
		studentDao.createStudent(student);

	}
	private Student getStudent(){
		Student student=new Student();
		student.setLname("Fred");
		student.setFname("Kipkemoi");
		return student;

	}
}
