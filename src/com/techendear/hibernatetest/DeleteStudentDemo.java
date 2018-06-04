package com.techendear.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			long id=1;
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student student2 = session.get(Student.class, id);
			System.out.println("Going to delete Student"+student2.getFirstName());
			session.delete(student2);
			System.out.println("Deleted");
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
