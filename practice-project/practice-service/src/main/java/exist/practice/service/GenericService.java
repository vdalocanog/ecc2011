package exist.practice.service;

import java.util.List;

public interface GenericService<T> {
	
	public List<T> findAll(String table);

	public boolean add(T object);

	public boolean delete(long id, Class<T> clazz);

	public List<T> findLike(String table, String column, String value);
}
