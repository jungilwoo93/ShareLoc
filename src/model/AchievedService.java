package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AchievedService implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private User from; // qui realise/rend le service
	@OneToMany
	private List<User> to; // qui benifie(ent) le service
	private int days; //nb de jours
	/*@Temporal(TemporalType.DATE)
	private Date startDate;*/
	private String img; // quand declarer la realisation possible attachant une photo
	private boolean valid;
	private boolean share;
	
	
	//quand service est valide, le cout ajoute dans le compte
	//ou partager le cout aux autres membres de la colocation
	
	public AchievedService() {
		this.from=null;
		this.to=null;
		this.days=0;
		this.img=null;
		this.valid=false;
		this.share=false;
	}
	
	public AchievedService(User from,List<User> to, int date, String img) {
		this.from=from;
		this.to=to;
		this.days=date;
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

	public int getDays() {
		return days;
	}

	public void setDays(int date) {
		this.days = date;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String urlImg){
		/*File f = new File(urlImg);
		BufferedImage bi= ImageIO.read(f);
		WritableRaster raster = bi.getRaster();
		DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
		this.img = data.getData();*/
		this.img=urlImg;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Image getLogo(String url) throws IOException {
		File f = new File(url);
		return ImageIO.read(f);
		
	}
	/*public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}*/
}
