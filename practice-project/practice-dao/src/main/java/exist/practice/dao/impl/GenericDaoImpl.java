package exist.practice.dao.impl;

import java.util.List;

import exist.practice.dao.GenericDao;

public class GenericDaoImpl<T> implements GenericDao<T> {

	public List<T> findAll(String table) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(T object) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(long id, Class<T> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<?> findLike(String table, String column, String value) {
		// TODO Auto-generated method stub
		return null;
	}


}
