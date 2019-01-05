package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Colocation;
import model.Service;
import model.User;

public class DaoService {
	@SuppressWarnings("unchecked")
	static public List<Service> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT u FROM Service u" );
		return query.getResultList();	
	}
	
	public static Service find(Object id) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT u FROM Service u WHERE u.title = :title");
			query.setParameter("title", id);
			return (Service) query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

	public static void create(Service u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public static void update(Service u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
