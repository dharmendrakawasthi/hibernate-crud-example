package com.techendear.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

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
			student2.setFirstName("Adi");
			student2.setLastName("Chu");
			System.out.println("Geting Student Data" + student2);
			session.createQuery("UPDATE Student set email='Hello_foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
