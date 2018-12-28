package controllers;

import java.util.List;

import dao.DaoColocation;
import model.Colocation;



public class ColocationManager {

	public static List<Colocation> getColocataions() {
		//List<User> lv = DaoUser.findAll();
		return DaoColocation.findAll();
	}
}
