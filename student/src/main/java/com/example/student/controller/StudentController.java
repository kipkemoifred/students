package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/students" )
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> getCustomers(){
        return studentService.getStudents();

    }
    @GetMapping(value = "{studentId}")
    public Student getStudent(@PathVariable("studentId") long studentId){
return studentService.getStudent(studentId);

    }



    //@PutMapping("{id}")
    //@DeleteMapping("{id}")
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping(value = "{studentId}")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student.getId(), student);
    }
    @DeleteMapping (value = "{studentId}")
    public void deleteStudent(@RequestBody Student student){
         studentService.deleteStudent(student.getId());
    }
//    public String dfg()
//    {
//        return "Working";
//    }
}
