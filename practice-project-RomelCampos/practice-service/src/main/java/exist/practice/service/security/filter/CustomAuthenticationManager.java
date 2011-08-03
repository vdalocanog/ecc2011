package exist.practice.service.security.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import exist.practice.Role;
import exist.practice.User;
import exist.practice.service.UserService;

public class CustomAuthenticationManager implements AuthenticationManager {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Md5PasswordEncoder passwordEncoder;
	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setPasswordEncoder(Md5PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
			User user = null;
		try{
			user = userService.findUser("userName", authentication.getName()).get(0);
		}catch(Exception e){
			e.printStackTrace();
			throw new BadCredentialsException("Username does not exist");
		}
		
		if(!user.getPassword().equals(authentication.getCredentials())){
			throw new BadCredentialsException("Invalid Credential");
		}
		
		return new UsernamePasswordAuthenticationToken(
				authentication.getName(),
				authentication.getCredentials(),
				getAuthorities(user.getRoleList()));
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
