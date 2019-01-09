package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AchievedService;
import model.Service;

public class DaoAchievedService {

	public static void update(AchievedService u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ShareLoc");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
