package com.lpu.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.lpu.entity.Department;
@Component
public class DepartmentDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

    public void addDepartment(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        em.close();
    }
    public Department getDepartmentById(int deptId) {
        EntityManager em = emf.createEntityManager();
        Department department = em.find(Department.class, deptId);
        em.close();
        return department;
    }
    public void updateDepartmentName(int deptId, String newName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department department = em.find(Department.class, deptId);
        department.setName(newName);

        em.getTransaction().commit();
        em.close();
    }
    public void deleteDepartment(int deptId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department department = em.find(Department.class, deptId);
        em.remove(department);

        em.getTransaction().commit();
        em.close();
    }
}
