package model;

import java.awt.Image;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AchievedService implements Serializable{
	@Id
	private User from; // qui realise/rend le service
	private List<User> to; // qui benifie(ent) le service
	private String date;
	private URL img; // quand declarer la realisation possible attachant une photo
	private boolean valid;
	private boolean share;
	//quand service est valide, le cout ajoute dans le compte
	//ou partager le cout aux autres membres de la colocation
	
	public AchievedService() {
		this.from=null;
		this.to=null;
		this.date=null;
		this.img=null;
		this.valid=false;
		this.share=false;
	}
	
	public AchievedService(User from,List<User> to, String date, URL img) {
		this.from=from;
		this.to=to;
		this.date=date;
		this.img=img;
		this.valid=false;
		this.share=false;
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

	public boolean isShare() {
		return share;
	}

	public void setShare(boolean share) {
		this.share = share;
	}
	
}
