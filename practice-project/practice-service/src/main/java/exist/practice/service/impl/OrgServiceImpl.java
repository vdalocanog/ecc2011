package exist.practice.service.impl;

import java.util.List;

import exist.practice.Org;
import exist.practice.dao.impl.GenericDaoImpl;
import exist.practice.service.OrgService;

public class OrgServiceImpl extends GenericDaoImpl<Org> implements OrgService {

	public List<Org> findAll(String table) {
		// TODO Auto-generated method stub
		List<Org> result = this.findAll(table);
		return result;
	}

	public boolean add(Org object) {
		// TODO Auto-generated method stub
		boolean result = this.add(object);
		return result;
	}

	public boolean delete(long id, Class<Org> clazz) {
		// TODO Auto-generated method stub
		boolean result = this.delete(id, clazz);
		return result;
	}

	public List<Org> findLike(String table, String column, String value) {
		// TODO Auto-generated method stub
		List<Org> result = this.findLike(table, column, value);
		return result;
	}

}
