package controllers;

import java.util.List;
import dao.DaoColocation;
import model.Colocation;



public class ColocationManager {

	public static List<Colocation> getColocations() {
		return DaoColocation.findAll();
	}
	
	public static Colocation getColocation(String id) {
		return DaoColocation.find(id);
	}
	
	public static boolean createColocation(String name) {
		Colocation c = DaoColocation.find(name);
		if (c == null) {
			c = new Colocation(name);
			DaoColocation.create(c);
			return true;
		}
		return false;
	}
	
	public static boolean update(String name, String newName) {
		Colocation c = DaoColocation.find(name);
		if(c!=null) {
			c.setName(newName);
			DaoColocation.update(c);
			return true;
		}
		return false;
	}
}
