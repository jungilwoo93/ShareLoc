package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import model.User;

public abstract class DaoAbstract<T> {

	/*public abstract List<T> getAll();
	public abstract T get(String login);
	public abstract void create();
	public abstract void update(T obj);
	public abstract void delete(T obj);*/
	//@PersistenceContext(unitName="ShareLoc")
	static EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("ShareLoc");
	//@PersistenceContext(unitName="ShareLoc")
	static EntityManager em = null;

	// attribut typant la facade : c'est la classe de l'objet métier
	private Class<T> classeEntite;

	/**
	 * Constructeur
	 * 
	 * @param classeEntite
	 *            La classe de l'objet metier
	 */
	public DaoAbstract(Class<T> classeEntite) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		this.classeEntite = classeEntite;
	}

	/**
	 * Methode abstraite a definir dans chaque sous-classe qui renvoie
	 * l'EntityManager correspondant a la classe.
	 * 
	 * @return l'entity manager
	 */
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = emfactory.createEntityManager();
			System.out.println("null");
		}
			
		return em;
	}
	/**
	 * Methode de creation d'un objet (ajout dans la base).
	 * 
	 * @param entite
	 */
	public T create(T entite) {
		final EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(entite);
		em.flush();
		em.getTransaction().commit();
		return entite;
	}

	/**
	 * Methode de modification d'un objet.
	 * 
	 * @param entite
	 */
	public void edit(T entite) {
		final EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.merge(entite);
		em.getTransaction().commit();
	}

	/**
	 * Methode de suppression d'un objet.
	 * 
	 * @param entite
	 */
	public void remove(T entite) {
		getEntityManager().remove(getEntityManager().merge(entite));
	}

	/**
	 * Methode de recherche d'un objet a partir de son identifiant.
	 * 
	 * @param id
	 * @return
	 * @return
	 */
	public T find(Object id) {
		return getEntityManager().find(classeEntite, id);
	}

	/**
	 * Methode recherchant tous les objets de ce type.
	 * 
	 * @return
	 */
	public List<T> findAll() {
		final EntityManager em = getEntityManager();
		final CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(classeEntite);
		cq.select(cq.from(classeEntite));
		/*Vector<T> v = (Vector<T>) getEntityManager().createQuery(cq).getResultList();
		if (v!=null)
			return new ArrayList<T>(v);
		return null;*/
		final List<T> results = em.createQuery(cq).getResultList();
        if (results == null) {
            return Collections.emptyList();
        }
        return results;
	}

	/**
	 * Methode renvoyant les n objets de ce type compris dans l'intervalle pass�
	 * en parametre (utile pour la pagination des resultats).
	 * 
	 * @param etendue
	 * @return
	 */
	public List<T> findRange(int[] etendue) {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery(classeEntite);
		cq.select(cq.from(classeEntite));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(etendue[1] - etendue[0]);
		q.setFirstResult(etendue[0]);
		return q.getResultList();
	}

	/**
	 * Methode renvoyant le nombre d'objet de ce type.
	 * 
	 * @return
	 */
	public int count() {
		CriteriaQuery<Object> cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(classeEntite);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}
}
