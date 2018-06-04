package com.techendear.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student = new Student("Dharmendra", "Awasthi", "dharmendrakawasthi@gmail.com");
			Student student2 = new Student("Raju", "Yadav", "Raji.Yadav@compny.com");
			session.save(student);
			session.save(student2);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
