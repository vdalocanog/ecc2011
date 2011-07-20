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
@RequestMapping("/saveUser.htm")
public class SaveUserForm {
	
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	public void setUserServiceImpl(UserService userService) {
		this.userService = userService;
	}
	//private UserService userService;
	//private CandidateService candidateService;

	//@Autowired
	//public BallotForm(UserService userService, CandidateService candidateService){
	//	System.out.println("Invoked 1: SaveUserForm");
	//	this.userService = userService;
	//	this.candidateService = candidateService;
	//}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest req) {
		System.out.println("Invoked: showForm");
		model.put("user", new User());
		return "saveUser";
	}
	
	
	//(Model model, @ModelAttribute("mappedModel") T mappedModel, BindingResult bindingResult, @RequestParam(value="submit",required=true) String submitType
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest req, ModelMap model, User user) {
	    System.out.println("Invoked: onSubmit");
	    String error = "Registration Failed! ";
	    boolean isSuccess = true;
	    if(!user.getUserName().equals("") && !user.getPassword().equals("") 
	    	&& !user.getFirstName().equals("") && !user.getLastName().equals("") 
	    	&& !user.getMi().equals("") && !user.getEmailAddress().equals(""))
	    {
		    if(user.getPassword().equals(req.getParameter("confirmPassword"))){
		    	try{
		    		Role role = this.roleService.findRole("roleId", "2").get(0);
		    		Set<Role> roleList = user.getRoleList();
		    		if(roleList == null){
		    			roleList = new HashSet<Role>();
		    		}
		    		roleList.add(role);
		    		user.setRoleList(roleList);
		    		userService.addUser(user);	
		    	} catch(Exception e){
		    		System.out.println("BLEHHHHHHHHHHH!");
		    		error += "Username already in use.";
		    		isSuccess = false;
		    	}
		    } else {
		    	error += "Passwords don't match.";
		    	isSuccess = false;
		    }
	    } else {
	    	error += "Make sure to fill-up all required fields.";
	    	isSuccess = false;
	    }
	    if(isSuccess) return "home";
	    model.put("user", user);
    	model.put("message", error);
    	return "saveUser";
	}	
	
}
