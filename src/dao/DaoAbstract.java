package dao;

import java.util.List;

import model.User;

public abstract class DaoAbstract<T> {

	public abstract List<T> getAll();
	public abstract T get(String login);
	public abstract void create();
	public abstract void update(T obj);
	public abstract void delete(T obj);
}
