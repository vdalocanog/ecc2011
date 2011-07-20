package exist.practice.controller;


import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exist.practice.Org;
import exist.practice.User;
import exist.practice.service.UserService;


@Controller
public class WebAppMiniProjMultiActionController {
	
	private UserService userService;
	
	@Autowired
	public void setUserServiceImpl(UserService userService) {
		this.userService = userService;
	}

    @RequestMapping("/viewProfile.htm")
    public ModelAndView viewProfile(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("viewProfile");
        
        User user = new User();
        user.setFirstName( "Glenn" );
        Set<Org> orgList = new HashSet<Org>();
        Org org1 = new Org(); org1.setOrgId( 1 ); org1.setOrgName( "A" ); orgList.add( org1 );
        Org org2 = new Org(); org2.setOrgId( 2 ); org2.setOrgName( "B" ); orgList.add( org2 );
        user.setOrgs( orgList );
        mav.addObject( "user", user );
        
        
        mav.addObject( "orgList", user.getOrgs() );
        
        return mav;
    }
    
    @RequestMapping("/viewUser.htm")
    public ModelAndView viewUser(HttpServletRequest req){
    	ModelAndView mav = new ModelAndView("viewProfile");
    	HttpSession session = req.getSession();
    	String uname = (String) session.getAttribute("uname");
    	mav.addObject("user", userService.findUser("userName", uname));
    	return mav;
    }
}
