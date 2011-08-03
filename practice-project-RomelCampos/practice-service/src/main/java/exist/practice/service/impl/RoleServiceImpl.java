package exist.practice.service.impl;

import java.util.List;

import exist.practice.Org;
import exist.practice.Role;
import exist.practice.dao.impl.GenericDaoImpl;
import exist.practice.service.RoleService;

public class RoleServiceImpl extends GenericDaoImpl<Role> implements RoleService {

	
	public List<Role> findAllRole() {
		// TODO Auto-generated method stub
		List<Role> result = this.findAll("Role");
		return result;
	}

	public boolean addRole(Role object) {
		// TODO Auto-generated method stub
		boolean result = this.add(object);
		return result;
	}

	public boolean updateRole(Role object) {
		// TODO Auto-generated method stub
		boolean result = this.update(object);
		return result;
	}

	public boolean deleteRole(long id, Class<Role> clazz) {
		// TODO Auto-generated method stub
		boolean result = this.delete(id, clazz);
		return result;
	}

	public List<Role> findRole(String column, String value) {
		// TODO Auto-generated method stub
		List<Role> result = this.findLike("Role", column, value);
		
		return result;
	}

}
