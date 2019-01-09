package controllers;

import java.io.IOException;
import java.util.List;

import dao.DaoAchievedService;
import dao.DaoColocation;
import dao.DaoService;
import dao.DaoUser;
import model.AchievedService;
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
	
	public static boolean createService(String nameColoc, String login,String title,String description,int cost,int days) {
		Service s = DaoService.find(title);
		Colocation c = DaoColocation.find(nameColoc);
		User u = DaoUser.find(login);
		if(u==null||c==null) {
			return false;
		}
		if (s == null) {
			s = new Service(c,u,title,description,cost);
			AchievedService as = new AchievedService();
			as.setDays(days);
			s.setAchieved(as);
			c.getServices().add(s);	
			DaoColocation.update(c);
			//DaoService.create(s);
			return true;
		}
		return false;
	}
	
	public static boolean realisation(String login,String nameColoc,String title,String urlFile,int share){
		Service s = DaoService.find(title);
		User u =DaoUser.find(login);
		Colocation c = DaoColocation.find(nameColoc);
		if (s != null&&u!=null) {
			AchievedService as = new AchievedService();
			as.setId(s.getAchieved().getId());
			as.setDays(s.getAchieved().getDays());
			as.setFrom(u);
			as.setImg(urlFile);
			if(share==1) {
				as.setTo(c.getUsers());
				as.setShare(true);
			}
			s.setAchieved(as);
			DaoAchievedService.update(as);
			DaoService.update(s);
			return true;
		}
		return false;
	}
	
	public static boolean validate(String login) {
		//pour voir
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
