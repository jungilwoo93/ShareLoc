package model;

import java.util.List;

public class AchievedService {
	private User from;
	private List<User> to;
	private int date;
	private String img;
	private boolean isValid;
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
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
}
