package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import model.User;

public class DaoUser extends DaoAbstract<User>{

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("User_EntityManager");
	static EntityManager em = null;

	// attribut typant la facade : c'est la classe de l'objet métier
	private Class<User> classeEntite;

	/**
	 * Constructeur
	 * 
	 * @param classeEntite
	 *            La classe de l'objet metier
	 */
	public DaoUser(Class<User> classeEntite) {
		this.classeEntite = classeEntite;
		this.em=getEntityManager();
		User user=new User();
		user.setEmail("panpan@uha.fr");
		user.setPassword("root");
		user.setFirstname("pan");
		user.setLastname("liuyan");
		this.em.persist(user);
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
	public User find(Object id) {
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
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	
}
