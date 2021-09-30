package com.example.jpaintro;

import com.example.jpaintro.pojos.Address;
import com.example.jpaintro.pojos.SchoolClass;
import com.example.jpaintro.pojos.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_JPA_Intro");
        EntityManager em = emf.createEntityManager();

        Student student1 = new Student(1l, "5DHIF", "Nico", "Baumann", LocalDate.now());
        Address address1 = new Address("Kaindorf", "Grazer Strasse", "8430");
        student1.setAddress(address1);
        address1.setStudent(student1);
//        em.persist(student1);

        Student student2 = new Student(2l, "5DHIF", "Adrian", "Berner", LocalDate.now());
        Address address2 = new Address("Kaindorf", "Grazer Strasse", "8430");
        student2.setAddress(address2);
        address2.setStudent(student2);
//        em.persist(student2);

        SchoolClass sc = new SchoolClass("5DHIF");
        sc.addStudent(student1);
        sc.addStudent(student2);
        em.persist(sc);

        em.getTransaction().begin();
        em.getTransaction().commit();

//        student1.setFirstname("Nikolaus");
//        em.getTransaction().begin();
//        em.getTransaction().commit();
//        em.detach(student1);


        em.close();
        emf.close();
    }
}
