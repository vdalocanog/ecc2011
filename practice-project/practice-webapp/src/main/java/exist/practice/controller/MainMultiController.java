package exist.practice.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import exist.practice.service.UserService;

@Controller
public class MainMultiController {	
	
	private UserService userService;
	
	@Autowired
	public void setUserServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/home.htm")
    public String home(HttpServletRequest req, ModelMap model){
    	HttpSession session = req.getSession();
    	session.setAttribute("uname", "i4chub2x"); ///////////////// for testing only
    	String uname = (String) session.getAttribute("uname");
    	model.put("uname", uname);
    	return "home";
    }
	
	@RequestMapping(value="/admin/admin.htm", method=RequestMethod.GET)
	public String loadAdminPage(){
		return "admin";
	}

	@RequestMapping("/viewUser.htm")
    public String viewUser(HttpServletRequest req, ModelMap model){
    	HttpSession session = req.getSession();
    	String uname = (String) session.getAttribute("uname");
    	model.put("user", userService.findUser("userName", uname).get(0));
    	return "viewProfile";
    }
	
}
