package controllers;

import java.util.List;

import dao.DaoColocation;
import dao.DaoService;
import dao.DaoUser;
import model.Colocation;
import model.Service;
import model.User;

public class ServiceManager {
	public static List<Service> getServices() {
		return DaoService.findAll();
	}
	
	public static Service getService(String id) {
		return DaoService.find(id);
	}
	
	public static boolean createService(String title,String description,String cost) {
		Service c = DaoService.find(title);
		if (c == null) {
			c = new Service(title,description,cost);
			DaoService.create(c);
			return true;
		}
		return false;
	}
	
	/*public static boolean update(String name, String newName) {
		Service c = DaoService.find(name);
		if(c!=null) {
			c.setName(newName);
			DaoService.update(c);
			return true;
		}
		return false;
	}*/
}
