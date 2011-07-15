package exist.practice.controller.forms;

import java.util.*;



import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//import com.exist.ecc.models.User;
//import com.exist.ecc.services.CandidateService;
//import com.exist.ecc.services.UserService;

@Controller
@RequestMapping("/saveUser.htm")
public class SaveUserForm {

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

		return "saveUser";
	}
	
	
	//(Model model, @ModelAttribute("mappedModel") T mappedModel, BindingResult bindingResult, @RequestParam(value="submit",required=true) String submitType
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest req, ModelMap model) {
		
	    System.out.println("Invoked: onSubmit");
		
		return "saveUserSuccess";
	}

	
	
}
