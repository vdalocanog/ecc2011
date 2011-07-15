package exist.practice;

import java.util.Set;
import javax.persistence.*;
import exist.practice.User;

@Entity
public class Org {

	@Id
	@GeneratedValue
	private long orgId = -1;
	private String orgName;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "OrgUser", joinColumns = @JoinColumn(name = "orgId"), inverseJoinColumns = @JoinColumn(name = "userId"))
	private Set<User> members;

	/**
	 * @return the orgId
	 */
	public long getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId
	 *            the orgId to set
	 */
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName
	 *            the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}
}
