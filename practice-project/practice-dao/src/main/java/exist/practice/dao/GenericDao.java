package exist.practice.dao;

import java.util.List;

public interface GenericDao<T> {

	public List<T> findAll(String table);
	public boolean add(T object);
	public boolean delete(long id, Class<T> clazz);
	public List<?> findLike(String table, String column, String value);
}
