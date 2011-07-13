package exist.practice.service.impl;

import java.util.List;

import exist.practice.service.GenericService;

public class GenericServiceImpl<T> implements GenericService<T>{

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
