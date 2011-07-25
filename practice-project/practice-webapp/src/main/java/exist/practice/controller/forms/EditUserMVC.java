package exist.practice.controller.forms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import exist.practice.Role;
import exist.practice.User;
import exist.practice.service.RoleService;
import exist.practice.service.UserService;
import exist.practice.validator.UsernameValidator;

@Controller
public class EditUserMVC {
	
	UsernameValidator unameValidator;
	
	public EditUserMVC(){
		unameValidator = new UsernameValidator();
	}
	
	private static UserService userService;

	@Autowired
	public void setUserServiceImpl(UserService userService) {
		EditUserMVC.userService = userService;
	}
	
	@Autowired
    private RoleService roleService;
	
	static public boolean isAvailable(final String uname) {
		if(userService.findUser("userName", uname).size() == 0) return true;
		return false;
	}
	
	@RequestMapping(value = "/editUser.htm", method = RequestMethod.GET)
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
	}
	
	@RequestMapping(value = "/editUser.htm", method = RequestMethod.POST)
    public String onSubmit(HttpServletRequest req, ModelMap model, User user) {
	    model.put("action", "edit" );
        System.out.println("Invoked: onSubmit");
        
        String error = "Registration Failed: <br />";
        
        User u = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() ).get(0);
        
        /*
        user.setUserId( u.getUserId() );
        System.out.println("getUserId---> " + user.getUserId());
        user.setUserName( u.getUserName() );
        System.out.println("getUserName---> " + user.getUserName());
        user.setPassword( u.getPassword() );
        System.out.println("getPassword---> " + user.getPassword());
        //System.out.println("confirmPassword---> " + req.getParameter("confirmPassword"));
        */
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
        /*
        if( (req.getParameter("birthDate")!=null) && !req.getParameter("birthDate").trim().equals("") ) {
            user.setBirthDate( req.getParameter("birthDate") );
        } else {
            user.setBirthDate( null );
        }
        System.out.println("getBirthDate---> " + user.getBirthDate());
         u.setBirthDate( user.getBirthDate().toString() );
         */
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
        
        /*
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
        */
 
        if (valid) {
            //Set<Role> roleList = u.getRoleList();
            //user.setRoleList(roleList);
        
            //userService.updateUser(user); 
            userService.updateUser(u); 
            return "redirect: home.htm";
        }
        
        model.put("confirmPassword", user.getPassword() );
        model.put("message", error);
        
        return "saveEditUser";       
        
    }   
	
}
