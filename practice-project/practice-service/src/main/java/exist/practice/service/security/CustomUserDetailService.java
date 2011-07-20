package exist.practice.service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import exist.practice.Role;
import exist.practice.service.UserService;

public class CustomUserDetailService implements UserDetailsService {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		UserDetails userDetails = null;

		try {
			exist.practice.User user = (exist.practice.User) userService
					.findUser("userName", username).get(0);

			userDetails = new User(user.getUserName(), user.getPassword()
					.toLowerCase(), true, true, true, true,
					this.getAuthorities(user.getRoleList()));
			System.out.println("CHECK DIRI:::"+user.getUserName());
		} catch (Exception e) {
			e.printStackTrace();

		}
		return userDetails;
	}

	public Collection<GrantedAuthority> getAuthorities(Set<Role> roleList) {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		Iterator<Role> iter = roleList.iterator();
		while (iter.hasNext()) {
			String role = iter.next().getRole();
			authorities.add(new GrantedAuthorityImpl(role));
			System.out.println("CHECK HERE:::"+role);
		}

		return authorities;
	}

}
