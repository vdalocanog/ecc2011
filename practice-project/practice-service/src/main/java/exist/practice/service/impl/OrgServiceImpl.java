package exist.practice.service.impl;

import java.util.List;

import exist.practice.Org;
import exist.practice.dao.impl.GenericDaoImpl;
import exist.practice.service.OrgService;

public class OrgServiceImpl extends GenericDaoImpl<Org> implements OrgService {

	public List<Org> findAllOrg() {
		// TODO Auto-generated method stub
		List<Org> res = this.findAll("Org");
		return res;
	}

	public boolean addOrg(Org object) {
		// TODO Auto-generated method stub
		boolean res = this.add(object);
		return res;
	}

	public boolean updateOrg(Org object) {
		// TODO Auto-generated method stub
		boolean res = this.update(object);
		return res;
	}

	public boolean deleteOrg(long id) {
		// TODO Auto-generated method stub
		boolean res = this.delete(id, Org.class);
		return res;
	}

	public List<Org> findOrg(String column, String value) {
		// TODO Auto-generated method stub
		List<Org> res = this.findLike("Org", column, value);
		return res;
	}
	
	public List<Org> findOrgs(String column, String value) {
        // TODO Auto-generated method stub
        List<Org> res = this.findContains("Org", column, value);
        return res;
    }

}
