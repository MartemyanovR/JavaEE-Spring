package ru.mart.testJPA2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testss {
	
	
	private EntityManager em;

    @Before
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Site" );
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void close() {
    	if(em.getTransaction().isActive()) {
    		em.getTransaction().commit();
    	}
        em.getEntityManagerFactory().close();
        em.close();
    }
    
    @Test
    public void shouldPersistCategory() {
    	Category cat = new Category();
    	cat.setTitle("new category");
    	// JUnit обеспечит тест свежим EntityManager'ом
    	em.persist(cat);
    }
    
    @Test
    public void shouldPersistCategoryAndTopics() {
    	Category cat = new Category();
    	cat.setTitle("category_Two");
    	Topic top = new Topic();
    	top.setTitle("topic");
    	top.setCategory(cat);
    	em.persist(cat);
    }
	

}
