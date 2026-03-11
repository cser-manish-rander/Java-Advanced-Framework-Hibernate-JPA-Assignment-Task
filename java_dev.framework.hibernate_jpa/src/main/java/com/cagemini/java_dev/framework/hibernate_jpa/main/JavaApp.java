
package com.cagemini.java_dev.framework.hibernate_jpa.main;

import java.util.Scanner;

import com.capgemini.java_dev.framework.hibernate_jpa.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JavaApp {

    public static void execution1() {

        Scanner sc = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Employee");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        int choice = 0;

        while(choice != 5) {

            System.out.println("\n----- Employee CRUD Menu -----");
            System.out.println("1. Add Employee");
            System.out.println("2. Read Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            choice = sc.nextInt();

            switch(choice) {

            case 1:

                tx.begin();

                Employee e = new Employee();

                System.out.println("Enter Employee Id:");
                e.setId(sc.nextInt());

                sc.nextLine();

                System.out.println("Enter First Name:");
                e.setFirstName(sc.nextLine());

                System.out.println("Enter Email Id:");
                e.setEmailId(sc.nextLine());

                System.out.println("Enter Contact Number:");
                e.setContactNumber(sc.nextLong());

                em.persist(e);

                tx.commit();

                System.out.println("Employee Added Successfully");

                break;


            case 2:

                System.out.println("Enter Employee Id to Read:");
                int readId = sc.nextInt();

                Employee emp = em.find(Employee.class, readId);

                if(emp != null) {
                    System.out.println(emp);
                } else {
                    System.out.println("Employee Not Found");
                }

                break;


            case 3:

                System.out.println("Enter Employee Id to Update:");
                int updateId = sc.nextInt();

                Employee updateEmp = em.find(Employee.class, updateId);

                if(updateEmp != null) {

                    sc.nextLine();

                    System.out.println("Enter New Email:");
                    updateEmp.setEmailId(sc.nextLine());

                    System.out.println("Enter New Contact Number:");
                    updateEmp.setContactNumber(sc.nextLong());

                    tx.begin();
                    em.merge(updateEmp);
                    tx.commit();

                    System.out.println("Employee Updated Successfully");
                } else {
                    System.out.println("Employee Not Found");
                }

                break;


            case 4:

                System.out.println("Enter Employee Id to Delete:");
                int deleteId = sc.nextInt();

                Employee delEmp = em.find(Employee.class, deleteId);

                if(delEmp != null) {

                    tx.begin();
                    em.remove(delEmp);
                    tx.commit();

                    System.out.println("Employee Deleted Successfully");
                } else {
                    System.out.println("Employee Not Found");
                }

                break;


            case 5:

                System.out.println("Exiting Program...");
                break;


            default:
                System.out.println("Invalid Choice");
            }
        }

        em.close();
        emf.close();
        sc.close();
    }
}

