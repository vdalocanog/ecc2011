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

import exist.practice.User;
import exist.practice.service.UserService;

//import com.exist.ecc.models.User;
//import com.exist.ecc.services.CandidateService;

@Controller
@RequestMapping("/saveUser.htm")
public class SaveUserForm {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
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
	    
	    //required
	    System.out.println( user.getUserId() );
	    System.out.println( user.getUserName() );
	    System.out.println( user.getPassword() );
	    System.out.println( req.getParameter( "confirmPassword" ) );
	    /*System.out.println( req.getParameter( "lastName" ) );
	    System.out.println( req.getParameter( "firstName" ) );
	    System.out.println( req.getParameter( "mi" ) );
	    System.out.println( req.getParameter( "emailAddress" ) );
	    System.out.println( req.getParameter( "gender" ) );*/
	    
	    //not required
	    /*System.out.println( req.getParameter( "birthDate" ) );
	    System.out.println( req.getParameter( "homeAddress" ) );
	    System.out.println( req.getParameter( "contactNumber" ) );*/
		
	    if(userService.addUser(user)) System.out.println("PERFECT");
	    else System.out.println("BORING!!!");
	    
		return "saveUserSuccess";
	}	
	
}
