package exist.practice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainMultiController {	

	@RequestMapping(value="/home.htm", method=RequestMethod.GET)
	public String loadHomePage(){
		return "home";
	}
	
	@RequestMapping(value="/admin/admin.htm", method=RequestMethod.GET)
	public String loadAdminPage(){
		return "admin";
	}

}
