package exist.practice.controller.forms;

import java.util.*;

/*

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


import com.exist.ecc.models.User;
import com.exist.ecc.services.CandidateService;
import com.exist.ecc.services.UserService;


@Controller
@RequestMapping("/saveUser.htm")
*/
public class SaveUserForm {
/*
	private UserService userService;
	private CandidateService candidateService;

	@Autowired
	public BallotForm(UserService userService, CandidateService candidateService){
		System.out.println("Invoked 1: SaveUserForm");
		this.userService = userService;
		this.candidateService = candidateService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest req) {

		String page = "voteFinish";
		
		if ( (req.getParameter("voterId")==null) || (req.getParameter("confirmationCode")==null) ||
				(req.getParameter("voterId").equals("")) || (req.getParameter("confirmationCode").equals("")) ) {
			model.addAttribute("message", "Confirmation info is invalid.");
			return page;
		}
		
		int voterId = Integer.parseInt( req.getParameter("voterId") );
		String confirmationCode = req.getParameter("confirmationCode");
		
		User user = userService.loadVoter(voterId);
		
		if ( (user == null) || !( userService.generateConfirmationCode(voterId).equals(confirmationCode) ) ) {
			model.addAttribute("message", "Confirmation info is invalid.");
			return page;
		} 
		
		//validate first the combination of voterId and confirmationCode
		if( userService.isEmailedVoter(voterId) ) {
			userService.setConfirmedVoter(voterId);
		} 
		
		//confirmed but not yet voted
		if( userService.isConfirmedVoter(voterId) ) {
			
			model.put("voterID", user.getVoterId() );
			model.put("fullName", user.getLastName() + ", " + user.getFirstName() + " " + user.getMiddleName() );
			String districtName = user.getDistrict().getDistrictName();
			String cityName = user.getDistrict().getCity().getCityName();
			String provinceName = user.getDistrict().getCity().getProvince().getProvinceName();
			model.put("fullAddress", districtName + ", " + cityName + ", " + provinceName );
			
			//load candidates -- using candidateService
			
			//national
			model.put("presidents", candidateService.loadAllPosition(CandidateService.PRESIDENT) );//choose 1
			model.put("vicePresidents", candidateService.loadAllPosition(CandidateService.VICE_PRESIDENT) );//choose 1
			model.put("senators", candidateService.loadAllPosition(CandidateService.SENATOR) );//choose 12
			
			//provincial
			int provinceCode = user.getDistrict().getCity().getProvince().getProvinceCode();//choose 1
			model.put("governors", candidateService.loadAllPosition(CandidateService.GOVERNOR, provinceCode) );//choose 1
			model.put("viceGovernors", candidateService.loadAllPosition(CandidateService.VICE_GOVERNOR, provinceCode) );//choose 1
			
			//city
			int cityCode = user.getDistrict().getCity().getCityCode();
			model.put("mayors", candidateService.loadAllPosition(CandidateService.MAYOR, cityCode) );//choose 1
			model.put("viceMayors", candidateService.loadAllPosition(CandidateService.VICE_MAYOR, cityCode) );//choose 1
			model.put("councilors", candidateService.loadAllPosition(CandidateService.COUNCILOR, cityCode) );//choose 6
			
			//district
			int districtCode = user.getDistrict().getDistrictCode();
			model.put("congressmans", candidateService.loadAllPosition(CandidateService.CONGRESSMAN, districtCode) );//choose 1
			
			page = "ballot";
			//set the voted flag if the user submits ballot (using the ballot form controller)
		} else {
			model.addAttribute("message", "Sorry, you can only vote once.");
		}

		System.out.println("Invoked 1: showForm");

		return page;
	}
	
	
	//(Model model, @ModelAttribute("mappedModel") T mappedModel, BindingResult bindingResult, @RequestParam(value="submit",required=true) String submitType
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest req, ModelMap model) {
		
		User user = userService.loadVoter( Integer.parseInt( req.getParameter("voterId") ) );
		
		if( user.getStatus()==3 ) {
			
			updateVote( req.getParameter("president") );
			updateVote( req.getParameter("vicePresident") );
			updateVote( req.getParameterValues("senator") );
			updateVote( req.getParameter("governor") );
			updateVote( req.getParameter("viceGovernor") );
			updateVote( req.getParameter("mayor") );
			updateVote( req.getParameter("viceMayor") );
			updateVote( req.getParameterValues("councilor") );
			updateVote( req.getParameter("congressman") );
	
			model.addAttribute("message", "You have casted your vote.");
			
			userService.setVotedVoter( Integer.parseInt( req.getParameter("voterId") ) );
		
		} else {
			model.addAttribute("message", "Voting not possible.");
		}
		
		
		return "voteFinish";
	}

	*/
	
}
