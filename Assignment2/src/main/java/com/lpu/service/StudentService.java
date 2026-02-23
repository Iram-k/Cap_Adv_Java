package com.lpu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.StudentDao;
import com.lpu.entity.Student;
@Component
public class StudentService {
	@Autowired
    private StudentDao studentDao;

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public void updateStudentEmail(int id, String newEmail) {
        studentDao.updateStudentEmail(id, newEmail);
    }

   public void deleteStudent(int id) {
	   studentDao.deleteStudent(id);
   }
}
