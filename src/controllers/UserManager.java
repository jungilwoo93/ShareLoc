package controllers;

import java.util.List;

import dao.DaoAbstract;
import dao.DaoUser;
import model.User;

//methode pour les utilisateurs puissent utiliser
public class UserManager {

	public static List<User> getUsers() {
		//List<User> lv = DaoUser.findAll();
		return DaoUser.findAll();
	}

	public static User getUser(String login) {		
		/*if (login==null)
			return null;*/
		
		return DaoUser.find(login);
	}
	
	public static User login(String login, String password) {		
		User u=DaoUser.find(login);
		if(u!=null && u.getPassword().equals(password))
			return u;
		return null;
		/*if(u!=null && Cryptage.checkPassword(password, u.password))
			return u;
		return null;*/
	}
	
	public static boolean createUser(String login, String password, String firstname, String lastname) {
		User u = DaoUser.find(login);
		if (u == null) {
			u = new User();
			u.setEmail(login);
			u.setPassword(password);
			u.setFirstname(firstname);
			u.setLastname(lastname);
			DaoUser.create(u);
			return true;
		}
		return false;
	}
	/*private static DaoAbstract<User> dao;//= new DaoUser();
	public UserManager() {
		UserManager.dao = new DaoUser();
	}
	public static List<User> getAllUsers() {
		List<User> lv = dao.findAll();
		return lv;
		//return null;
	}

	public static User getUser(String login) {
		// TODO Auto-generated method stub
		if(login == null) {
			return null;
		}
		User u = new User();
		u.setEmail(login);
		u.setPassword("feel123");
		u.setFirstname("pan");
		u.setLastname("liuyan");
		//User u = dao.find(login);
		return u;
	}

	public static void createUser() {
		// TODO Auto-generated method stub
		
	}

	public static void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public static void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	public static User login(String login, String password) {
		// TODO Auto-generated method stub
		//return new User();
	//}
	 * 
	 */
}
