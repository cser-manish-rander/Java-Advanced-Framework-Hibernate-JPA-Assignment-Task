package java_advanced.framework_hibernate_one_to_one.mini_project.execution;

import java.util.Scanner;

import javax.persistence.*;

import java_advanced.framework_hibernate_one_to_one.mini_project.entity.*;

public class JavaApp {

public static void execution(){

Scanner sc = new Scanner(System.in);

EntityManagerFactory emf =
Persistence.createEntityManagerFactory("One_to_One_Project");

EntityManager em = emf.createEntityManager();

EntityTransaction et = em.getTransaction();

System.out.print("Enter University Name: ");
String universityName = sc.nextLine();

System.out.print("Enter College Name: ");
String collegeName = sc.nextLine();

System.out.print("Enter Department Name: ");
String deptName = sc.nextLine();

System.out.print("Enter Student Name: ");
String studentName = sc.nextLine();

System.out.print("Enter Project Title: ");
String projectName = sc.nextLine();

Project project = new Project();
project.setName(projectName);

Student student = new Student();
student.setName(studentName);
student.setProject(project);

Department department = new Department();
department.setName(deptName);
department.setStudent(student);

College college = new College();
college.setName(collegeName);
college.setDepartment(department);

University university = new University();
university.setName(universityName);
university.setCollege(college);

et.begin();
em.persist(university);
et.commit();

System.out.println("Data Inserted Successfully");

em.close();
emf.close();
sc.close();

}

}