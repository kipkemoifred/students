package com.example.student.dao;

import com.example.student.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
    @Autowired
    public SessionFactory sessionFactory;
    public void createStudent(Student student){
        Session session=null;
        try {
session=sessionFactory.openSession();
session.beginTransaction();

Integer id=(Integer)session.save(student);
            System.out.println("student is created with id :"+id);
session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
