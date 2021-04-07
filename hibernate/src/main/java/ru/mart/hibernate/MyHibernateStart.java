package ru.mart.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MyHibernateStart {

	public static void main(String[] args) throws InterruptedException {
		
		SessionFactory sessionFactory = new Configuration()	
				.addAnnotatedClass(Items.class)				//указываем что данный класс будет загружен(mapping) в hibernate
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetails.class)
				.buildSessionFactory();
		
		Session session = null;

//		=== CREATE ===
//		session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		Items item = new Items("cockeis", 150);
//		System.out.println(item);
//		session.save(item);
//		System.out.println(item);
//		session.getTransaction().commit();	
		
		
//		=== READ ===
//		session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		Items itemFromDb = session.get(Items.class, 2L);
//		System.out.println(itemFromDb);
//		session.getTransaction().commit();
	
//		=== UPDATE ===
//		session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		Items itemFromDb = session.get(Items.class, 2L);
//		System.out.println(itemFromDb);
//		session.evict(itemFromDb);		//evict удаляет объект из персистент контекста, и дальнейшая работа с ним будет происходить отдельно от базы
//		itemFromDb.setPrice(250);		
//		itemFromDb.setPrice(280);
//		itemFromDb = session.get(Items.class, 2L);  // при получении, объект снова в контексте 
//		itemFromDb.setPrice(350);
//		System.out.println(itemFromDb);
//		TimeUnit.SECONDS.sleep(20);
//		session.getTransaction().commit();

//		=== DELETE ===
//		session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		Items itemFromDb = session.get(Items.class, 2L);
//		System.out.println(itemFromDb);
//		session.remove(itemFromDb);  // нужна проверка на null, тк remove бросает IllegalArgumentException при null
//		session.remove(itemFromDb);
//		session.getTransaction().commit();
				
//		=== QUERY ===
//		session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		Items itemFromDb = session.createQuery("select i from Items i where i.price = :price", Items.class)
//				.setParameter("price", 150 )     // установка параметров в ":" value 
//				.getSingleResult();    			   //NoResultException  если запрос ничего не возвращает
//		System.out.println(itemFromDb);
//		session.getTransaction().commit();
		
//		=== QUERY list===
//		session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		List<Items> listItemFromDb = session.createQuery("select i from  Items i where i.price = :price", Items.class)
//				.setParameter("price", 120)
//				.getResultList();
//		System.out.println(listItemFromDb);
//		session.getTransaction().commit();
				
//		=== One to One ===
//		session = sessionFactory.getCurrentSession();
//		session.beginTransaction();
//		User user = session.get(User.class, 1L);
//		System.out.println(user);
//		System.out.println(user.getDetails());
//		System.out.println(user.getDetails().getUser());
//		session.getTransaction().commit();
		
//		=== One to One feedBack===
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		UserDetails userDetails = session.get(UserDetails.class, 1L);
		System.out.println(userDetails);
		System.out.println(userDetails.getUser());
		session.getTransaction().commit();
		
		
		sessionFactory.close();
	}
	
	
}
