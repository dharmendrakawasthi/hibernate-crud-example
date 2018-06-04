package com.techendear.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student = new Student("Dharmendra3", "Awasthi3", "dharmendrakawasthi3@gmail.com");
			session.save(student);
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Student ID: " + student.getId());
			Student student2 = session.get(Student.class, student.getId());
			System.out.println("Geting Student Data" + student2);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
