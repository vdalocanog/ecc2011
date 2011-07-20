package exist.practice.service;

import java.util.List;

import exist.practice.Role;

public interface RoleService {
	public List<Role> findAllRole();

	public boolean addRole(Role object);
	
	public boolean updateRole(Role object);

	public boolean deleteRole(long id, Class<Role> clazz);

	public List<Role> findRole(String column, String value);

}
