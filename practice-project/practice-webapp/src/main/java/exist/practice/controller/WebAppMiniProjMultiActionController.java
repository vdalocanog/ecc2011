package exist.practice.controller;

/*
import java.io.IOException;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exist.ecc.models.User;
import com.exist.ecc.services.CandidateService;
import com.exist.ecc.services.UserService;

@Controller
*/
public class WebAppMiniProjMultiActionController {

    /*
	UserService userService;
	CandidateService candidateService;
	
	@Autowired
	public WebAppMiniProjMultiActionController(
			UserService userService, 
			CandidateService candidateService){
		
		this.userService = userService;
		this.candidateService = candidateService;
		System.out.println("Invoked 1: WebAppMiniProjMultiActionController");
		
	}
	
	@RequestMapping("/confirmVoter.htm")
	public ModelAndView confirmVoter(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView("confirmVoter");
		
		mav.addObject("months", new java.text.DateFormatSymbols().getMonths() );	
		mav.addObject("yearNow", Calendar.getInstance().get(Calendar.YEAR) );
		
		return mav;
	}
	
	
	// redirects user to log-in if username is not in sessions 
	public static void validateSession(HttpServletRequest req, HttpServletResponse res) {
		
		boolean create = true;
		HttpSession session = req.getSession(create);
		
		String username = (String) session.getAttribute("username");
		
		if( (username==null) || (username.equals("")) ) {
			try {
				res.sendRedirect("login.htm");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	*/
	

}
