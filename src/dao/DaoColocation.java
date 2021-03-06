package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Account;
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
		em.flush();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static void inviteUser(Colocation coloc, String login) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		Colocation c = em.find(Colocation.class, coloc.getId());
		User u = em.find(User.class, login);
		Account a = new Account(c,u);
		em.getTransaction().begin();
		em.persist(a);
		em.flush();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static Colocation find(Object id) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT u FROM Colocation u WHERE u.name = :name");
			query.setParameter("name", id);
			return (Colocation) query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		return em.find(Colocation.class, id);*/
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
