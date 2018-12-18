package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Colocation;
import model.User;

public class DaoColocation extends DaoAbstract<Colocation>{
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("User_EntityManager");
	static EntityManager em = null;

	// attribut typant la facade : c'est la classe de l'objet métier
	private Class<Colocation> classeEntite;

	/**
	 * Constructeur
	 * 
	 * @param classeEntite
	 *            La classe de l'objet metier
	 */
	public DaoColocation(Class<Colocation> classeEntite) {
		this.classeEntite = classeEntite;
		DaoColocation.em=getEntityManager();

	}

	/**
	 * Methode abstraite a definir dans chaque sous-classe qui renvoie
	 * l'EntityManager correspondant a la classe.
	 * 
	 * @return l'entity manager
	 */
	protected EntityManager getEntityManager() {
		if (em == null)
			em = emfactory.createEntityManager();
		return em;
	}

	/**
	 * Methode de recherche d'un objet a partir de son identifiant.
	 * 
	 * @param id
	 * @return
	 * @return
	 */
	public Colocation find(Object id) {
		return getEntityManager().find(classeEntite, id);
	}

	/**
	 * Methode recherchant tous les objets de ce type.
	 * 
	 * @return
	 */
	public ArrayList<User> findAll() {
		//CriteriaQuery<User> cq = (CriteriaQuery<User>) getEntityManager().getCriteriaBuilder().createQuery();
		//cq.select(cq.from(classeEntite));
		//Vector<User> v = (Vector<User>) getEntityManager().createQuery(cq).getResultList();
		//if (v!=null)
		//	return new ArrayList<User>(v);
		return null;
	}

	@Override
	public List<Colocation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Colocation get(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Colocation obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Colocation obj) {
		// TODO Auto-generated method stub
		
	}

	
	

}
