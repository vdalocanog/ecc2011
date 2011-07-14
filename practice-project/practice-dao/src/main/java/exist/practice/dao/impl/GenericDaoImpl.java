package exist.practice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import exist.practice.dao.GenericDao;

public class GenericDaoImpl<T> extends HibernateDaoSupport implements GenericDao<T> {

	@SuppressWarnings("unchecked")
	public List<T> findAll(String table) {
		// TODO Auto-generated method stub
		String query = "FROM "+table;
		List<T> results = new ArrayList<T>();
		try{
			results = this.getHibernateTemplate().find(query);
		}catch(Exception e){
			e.printStackTrace();
			results = null;
		}
		return results;
	}

	public boolean add(T object) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			this.getHibernateTemplate().save(object);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}
		return result;
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
