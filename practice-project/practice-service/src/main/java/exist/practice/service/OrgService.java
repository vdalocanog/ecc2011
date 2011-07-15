package exist.practice.service;

import java.util.List;

import exist.practice.Org;


public interface OrgService {
	public List<Org> findAll(String table);

	public boolean add(Org object);

	public boolean delete(long id, Class<Org> clazz);

	public List<Org> findLike(String table, String column, String value);

}
