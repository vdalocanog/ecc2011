package exist.practice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exist.practice.dao.GenericDao;

@Repository
@Transactional
public class GenericDaoImpl<T> implements GenericDao<T> {// extends
															// HibernateDaoSupport
															// implements
															// GenericDao<T> {
	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<T> findAll(String table) {
		// TODO Auto-generated method stub
		String query = "FROM " + table;
		List<T> results = new ArrayList<T>();
		try {
			results = hibernateTemplate.find(query);
		} catch (Exception e) {
			e.printStackTrace();
			results = null;
		}
		return results;
	}

	@Transactional(readOnly = false)
	public boolean add(T object) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			hibernateTemplate.save(object);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	@Transactional(readOnly = false)
	public boolean delete(long id, Class<T> clazz) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			hibernateTemplate.delete(hibernateTemplate.load(clazz, id));
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = false)
	public List<T> findLike(String table, String column, String value) {
		// TODO Auto-generated method stub
		String query = "FROM "+table+" WHERE "+column+"='"+value+"'";
		List<T> result = new ArrayList<T>();
		try{
			result = hibernateTemplate.find(query);
		}catch(Exception e){
			e.printStackTrace();
			result = null;
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
    @Transactional(readOnly = false)
    public List<T> findContains(String table, String column, String value) {
        // TODO Auto-generated method stub
        String query = "FROM "+table+" WHERE "+column+" LIKE '%"+value+"%'";
        List<T> result = new ArrayList<T>();
        try{
            result = hibernateTemplate.find(query);
        }catch(Exception e){
            e.printStackTrace();
            result = null;
        }
        return result;
    }

	public boolean update(T object) {
		// TODO Auto-generated method stub
		boolean result = false;
		try{
			//hibernateTemplate.update(object);
		    hibernateTemplate.merge(object);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
