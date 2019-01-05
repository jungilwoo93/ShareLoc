package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Colocation;
import model.Service;
import model.User;

public class DaoColocation {
	@SuppressWarnings("unchecked")
	public static List<Colocation> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Colocation c" );
		return query.getResultList();	
	}
	
	public static void create(Colocation c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static void inviteUser(User u) {
		
	}
	
	public static Colocation find(Object id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		return em.find(Colocation.class, id);
	}
	
	public static Service findSercive(Object id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		return em.find(Service.class, id);
	}
	
	public static void update(Colocation c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();	
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
