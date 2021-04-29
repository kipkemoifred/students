package com.example.student.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.example.student.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private long studentIdCount = 1;
    private List<Student> studentList = new CopyOnWriteArrayList<>();

    public Student addStudent(Student student) {
        student.setId(studentIdCount);
        studentList.add(student);
        studentIdCount++;
        return student;

    }

    public List<Student> getStudents() {

        return studentList;
    }

    public Student getStudent(long studentId) {
        return studentList
                .stream()
                .filter(c -> c.getId() == studentId)
                .findFirst()
                .get();

    }
    public Student updateStudent(long studentId,Student student){
        studentList
                .stream()
                .forEach(c->{
                    if(c.getId()==studentId){
                        c.setId(student.getId());
                        c.setFname(student.getFname());
                        c.setLname(student.getLname());
                        c.setGender(student.getGender());
                    }

                });
        return studentList
                .stream()
                .filter(c->c.getId()==studentId)
                .findFirst()
                .get();

    }
    public void deleteStudent(long studentId){
        studentList
                .stream()

                .forEach(c->{
                    if(c.getId()==studentId)
                    studentList.remove(c);
                });

    }



}
