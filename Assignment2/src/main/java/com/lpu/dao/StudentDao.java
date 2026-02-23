package com.lpu.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.lpu.entity.Student;
@Component
public class StudentDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
    public void addStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }
    
    public Student getStudentById(int studentId) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, studentId);
        em.close();
        return student;
    }

    public void updateStudentEmail(int studentId, String newEmail) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = em.find(Student.class, studentId);
        student.setEmail(newEmail);

        em.getTransaction().commit();
        em.close();
    }
    public void deleteStudent(int studentId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student student = em.find(Student.class, studentId);
        em.remove(student);

        em.getTransaction().commit();
        em.close();
    }
}
