package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Colocation;

public class DaoColocation {
	@SuppressWarnings("unchecked")
	static public List<Colocation> findAll(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT c FROM Colocation c" );
		return query.getResultList();	
	}
}
