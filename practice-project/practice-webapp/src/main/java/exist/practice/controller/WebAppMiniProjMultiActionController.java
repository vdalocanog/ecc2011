package exist.practice.controller;


import java.io.IOException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exist.practice.User;
import exist.practice.Org;


@Controller
public class WebAppMiniProjMultiActionController {

	
    
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
    


}
