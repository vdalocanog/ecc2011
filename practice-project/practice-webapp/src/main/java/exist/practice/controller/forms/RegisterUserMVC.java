package exist.practice.controller.forms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import exist.practice.User;
import exist.practice.service.UserService;
import exist.practice.validator.UsernameValidator;

@Controller
public class RegisterUserMVC {
	
	UsernameValidator unameValidator;
	
	public RegisterUserMVC(){
		unameValidator = new UsernameValidator();
	}
	
	private static UserService userService;

	@Autowired
	public void setUserServiceImpl(UserService userService) {
		RegisterUserMVC.userService = userService;
	}
	
	static public boolean isAvailable(final String uname) {
		if(userService.findUser("userName", uname) == null) return true;
		return false;
	}
	
	@RequestMapping(value = "/registerVoter.htm", method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		model.put("user", new User());
		model.put("message", "Fill-up all required fields.");
		return "saveUser";
	}
	
	@RequestMapping(value = "/checkUname", method = RequestMethod.GET)
	public @ResponseBody String checkUname(@RequestParam String uname) {
		String res = "";
		if(!unameValidator.validate(uname)) return "too short/long or has invalid chars";
		if(!RegisterUserMVC.isAvailable(uname)) return "already exist";
		return res;
	}	
}
