package controllers;

import java.util.List;

import dao.DaoUser;
import model.User;

//methode pour les utilisateurs puissent utiliser
public class UserManager {

	static DaoUser dao = new DaoUser();
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
		User u = dao.find(login);
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
		return new User();
	}
}
