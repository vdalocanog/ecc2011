package exist.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import exist.practice.dao.GenericDao;
import exist.practice.service.GenericService;

public class GenericServiceImpl<T> implements GenericService<T>{

	private GenericDao<T> genericDao;
	
	@Autowired
	public void setGenericDao(GenericDao<T> genericDao) {
		this.genericDao = genericDao;
	}

	public List<T> findAll(String table) {
		// TODO Auto-generated method stub
		List<T> result = this.genericDao.findAll(table);
		return result;
	}

	public boolean add(T object) {
		// TODO Auto-generated method stub		
		boolean result = this.genericDao.add(object);		
		return result;
	}

	public boolean delete(long id, Class<T> clazz) {
		// TODO Auto-generated method stub
		boolean result = this.delete(id, clazz);
		return result;
	}

	public List<T> findLike(String table, String column, String value) {
		// TODO Auto-generated method stub
		List<T> result = this.findLike(table, column, value);
		return result;
	}



}
