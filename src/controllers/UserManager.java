package controllers;

import java.util.List;

import dao.DaoUser;
import model.User;

//methode pour les utilisateurs puissent utiliser
public class UserManager {

	static DaoUser dao = new DaoUser(User.class);
	public static List<User> getAllUsers() {
		List<User> lv = dao.findAll();
		return lv;
		//return null;
	}

	public static User getUser(String login) {
		// TODO Auto-generated method stub
		return (User) dao.find(login);
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
	
	public static void connect(String login, String pw) {
		
	}
}
