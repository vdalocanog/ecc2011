package exist.practice.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainMultiController {	
	

	/*@RequestMapping(value="/home.htm", method=RequestMethod.GET)
	public String loadHomePage(ModelMap map){
		map.put("uname", "sample");
		return "home";
	}*/
	@RequestMapping("/home.htm")
    public ModelAndView home(HttpServletRequest req){
    	ModelAndView mav = new ModelAndView("home");
    	HttpSession session = req.getSession();
    	session.setAttribute("uname", "romel"); ///////////////// for testing only
    	String uname = (String) session.getAttribute("uname");
    	mav.addObject("uname", uname);
    	return mav;
    }
	
	@RequestMapping(value="/admin/admin.htm", method=RequestMethod.GET)
	public String loadAdminPage(){
		return "admin";
	}

}
