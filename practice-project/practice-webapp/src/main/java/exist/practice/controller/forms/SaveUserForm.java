package exist.practice.controller.forms;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exist.practice.User;
import exist.practice.service.UserService;

@Controller
@RequestMapping("/saveUser.htm")
public class SaveUserForm {
	
	private UserService userService;
	
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
		userService.addUser(user);
		return "saveUserSuccess";
	}	
	
}
