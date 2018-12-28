package model;

import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AchievedService {
	@Id
	private User from;
	private List<User> to;
	private String date;
	private URL img;
	private boolean valid=false;
	
	public AchievedService() {
		
	}
	
	public AchievedService(User from,List<User> to, String date, URL img) {
		this.from=from;
		this.to=to;
		this.date=date;
		this.img=img;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public List<User> getTo() {
		return to;
	}

	public void setTo(List<User> to) {
		this.to = to;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public URL getImg() {
		return img;
	}

	public void setImg(URL img) {
		this.img = img;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
