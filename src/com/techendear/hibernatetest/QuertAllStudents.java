package com.techendear.hibernatetest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QuertAllStudents {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
			session.getTransaction().commit();
			int i=0;
			for(Student s:students) {
				System.out.println("Student : "+ ++i);
				System.out.println(s.getFirstName());
				System.out.println(s.getLastName());
				System.out.println(s.getEmail());
				System.out.println("==========================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
