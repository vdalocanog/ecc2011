package exist.practice.controller.forms;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exist.practice.Role;
import exist.practice.User;
import exist.practice.service.RoleService;
import exist.practice.service.UserService;

@Controller
public class EditUserMVC {
	
	@Autowired
	private RoleService roleService;
	private static UserService userService;

	@Autowired
	public void setUserServiceImpl(UserService userService) {
		EditUserMVC.userService = userService;
	}
	
	/*@RequestMapping(value = "/editUser.htm", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
	    model.put("action", "edit" );
	    
	    User user = new User();
	    
	    System.out.println( "USERNAME >>>>>>>>>>>>>>>>> " + SecurityContextHolder.getContext().getAuthentication().getName() );

	    List<User> userList = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() );
        
        if ( userList.size() > 0 ) {
            user = userList.get(0);
        
            model.put("user", user );
        }
        
        model.put("confirmPassword", user.getPassword() );
		model.put("message", "Fill-up all required fields.");
		
		return "saveEditUser";
	}*/
	
	@RequestMapping(value = "/editUser.htm", method = RequestMethod.GET)
	public String loadEditUserForm(HttpServletRequest req, ModelMap model) {
		model.put("message", "Editing Profile");
		User user = (User) req.getSession().getAttribute("user");
		model.put("user", user);
		req.getSession().setAttribute("status", "");
		return "saveEditUser";
	}
	
	@RequestMapping(value = "/saveEditUser.htm", method = RequestMethod.POST)
    public String onSubmit(ModelMap model, User user) {
	    /*model.put("action", "edit" );
        System.out.println("Invoked: onSubmit");
        
        String error = "Registration Failed: <br />";
        
        User u = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() ).get(0);
        
        
        user.setUserId( u.getUserId() );
        System.out.println("getUserId---> " + user.getUserId());
        user.setUserName( u.getUserName() );
        System.out.println("getUserName---> " + user.getUserName());
        user.setPassword( u.getPassword() );
        System.out.println("getPassword---> " + user.getPassword());
        //System.out.println("confirmPassword---> " + req.getParameter("confirmPassword"));
        
        System.out.println("getFirstName---> " + user.getFirstName());
         u.setFirstName( user.getFirstName() );
        System.out.println("getLastName---> " + user.getLastName());
         u.setLastName( user.getLastName() );
        System.out.println("getMi---> " + user.getMi());
         u.setMi( user.getMi() );
        System.out.println("getEmailAddress---> " + user.getEmailAddress());
         u.setEmailAddress( user.getEmailAddress() );
        System.out.println("getGender---> " + user.getGender());
         u.setGender( user.getGender() );
        
        if( (req.getParameter("birthDate")!=null) && !req.getParameter("birthDate").trim().equals("") ) {
            user.setBirthDate( req.getParameter("birthDate") );
        } else {
            user.setBirthDate( null );
        }
        System.out.println("getBirthDate---> " + user.getBirthDate());
         u.setBirthDate( user.getBirthDate().toString() );
         
        System.out.println("getHomeAddress---> " + user.getHomeAddress());
         u.setHomeAddress( user.getHomeAddress() );
        System.out.println("getContactNumber---> " + user.getContactNumber());
         u.setContactNumber( user.getContactNumber() );
        System.out.println("isEnabled---> " + user.isEnabled());
         u.setEnabled( user.isEnabled()  );
        
        boolean valid = true;
        
        // !user.getPassword().equals("") &&
        if ( !user.getFirstName().equals("") 
            && !user.getLastName().equals("") 
            && !user.getMi().equals("") 
            && !user.getEmailAddress().equals("")) {
        } else { 
            error += "Make sure to fill-up all required fields. <br/ >";
            valid = false;
        }
        
        
        if (user.getPassword().length() > 3){
        } else { 
            error += "Password too short. <br/ >";
            valid = false;
        }
        
        if (user.getPassword().equals(req.getParameter("confirmPassword"))){
        } else {
            error += "Passwords don't match. <br/ >";
            valid = false;
        }
        
 
        if (valid) {
            //Set<Role> roleList = u.getRoleList();
            //user.setRoleList(roleList);
        
            //userService.updateUser(user); 
            userService.updateUser(u); 
            return "redirect: home.htm";
        }
        
        model.put("confirmPassword", user.getPassword() );
        model.put("message", error);*/
		
		user.setFullName(user.getFirstName() +" "+ user.getMi() +". "+ user.getLastName());
		
		Role role = this.roleService.findRole("roleId", "2").get(0);
		Set<Role> roleList = user.getRoleList();
		if (roleList == null) {
			roleList = new HashSet<Role>();
		}
		roleList.add(role);
		user.setRoleList(roleList);
		
		String msg;
		if ( !user.getFirstName().equals("") 
	            && !user.getLastName().equals("") 
	            && !user.getMi().equals("") 
	            && !user.getEmailAddress().equals("")) 
		{
			userService.updateUser(user);
			msg = "Changes Saved.";
        } else { 
            msg = "Make sure to fill-up all required fields.";
        }
		model.put("message", msg);
        return "saveEditUser";       
    }   
}
