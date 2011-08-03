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
public class EditPasswordMVC {
	
	UsernameValidator unameValidator;
	
	public EditPasswordMVC(){
		unameValidator = new UsernameValidator();
	}
	
	private static UserService userService;

	@Autowired
	public void setUserServiceImpl(UserService userService) {
		EditPasswordMVC.userService = userService;
	}
	
	@Autowired
    private RoleService roleService;
	
	static public boolean isAvailable(final String uname) {
		if(userService.findUser("userName", uname).size() == 0) return true;
		return false;
	}
	
	@RequestMapping(value = "/editPassword.htm", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
	    model.put("action", "editPassword" );
	    
	    User user = new User();
        
        System.out.println( "USERNAME >>>>>>>>>>>>>>>>> " + SecurityContextHolder.getContext().getAuthentication().getName() );

        List<User> userList = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() );
        
        if ( userList.size() > 0 ) {
            user = userList.get(0);
        
            model.put("user", user );
            
        }
        
		model.put("message", "Fill-up all required fields.");
		
		return "saveEditPassword";
	}
	
	@RequestMapping(value = "/editPassword.htm", method = RequestMethod.POST)
    public String onSubmit(HttpServletRequest req, ModelMap model, User user) {
	    model.put("action", "editPassword" );
        System.out.println("Invoked: onSubmit");
        
        String error = "Registration Failed: <br />";
        
        User u = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() ).get(0);

        System.out.println("TRUE oldPassword---> " + u.getPassword());
        System.out.println("oldPassword---> " + req.getParameter("oldPassword"));
        System.out.println("getPassword---> " + user.getPassword());
        System.out.println("confirmPassword---> " + req.getParameter("confirmPassword"));
        
        
        boolean valid = true;

        if ( u.getPassword().equals(req.getParameter("oldPassword")) ) {
        } else { 
            error += "Old password invalid. <br/ >";
            valid = false;
        }
        
        if (req.getParameter("password").length() > 3){
        } else { 
            error += "New password too short. <br/ >";
            valid = false;
        }
        
        if (req.getParameter("password").equals(req.getParameter("confirmPassword"))){
        } else {
            error += "New password and confirmation don't match. <br/ >";
            valid = false;
        }
 
        if (valid) {
            u.setPassword( req.getParameter("password") );
            userService.updateUser(u); 
            return "redirect: home.htm";
        }
        
        model.put("confirmPassword", user.getPassword() );
        model.put("message", error);
        
        return "saveEditPassword";       
        
    }   
	
}
