package dao;

import java.util.List;

import model.User;

public abstract class DaoAbstract<T> {

	public abstract List<User> getAllUsers();
	public abstract User getUser(String login);
	public abstract void createUser();
	public abstract void updateUser(User user);
	public abstract void deleteUser(User user);
}
