/*package exist.practice.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exist.practice.Org;
import exist.practice.User;
import exist.practice.service.OrgService;
import exist.practice.service.UserService;


@Controller
public class WebAppMiniProjMultiActionController {
	
	private UserService userService;
	
	private OrgService orgService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
<<<<<<< HEAD
	}
=======
	}
	
	@Autowired
    public void setOrgService(OrgService orgService) {
        this.orgService = orgService;
    }
>>>>>>> 75dbb6d9b09ae56b3316d0bc059cdc3754bafa1f

    @RequestMapping("/viewProfile.htm")
    public ModelAndView viewProfile(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("viewProfile");
        
        User user = new User();
        
        
        user.setFirstName( "Glenn" );
        Set<Org> orgList = new HashSet<Org>();
        Org org1 = new Org(); org1.setOrgId( 1 ); org1.setOrgName( "A" ); orgList.add( org1 );
        Org org2 = new Org(); org2.setOrgId( 2 ); org2.setOrgName( "B" ); orgList.add( org2 );
        user.setOrgs( orgList );
        

        System.out.println( "USERNAME >>>>>>>>>>>>>>>>> " + SecurityContextHolder.getContext().getAuthentication().getName() );
        
        List<User> userList = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() );
        
        if ( userList.size() > 0 ) {
            user = userList.get(0);
            mav.addObject( "user", user );
        }
        
        return mav;
    }
    
    @RequestMapping("/viewOrgs.htm")
    public ModelAndView viewOrgs(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("viewOrgs");
 
        List<Org> orgList = new ArrayList<Org>();
        orgList = orgService.findAllOrg();
        
        mav.addObject( "orgList", orgList );
        
        return mav;
    }
    
    @RequestMapping("/joinOrg.htm")
    public ModelAndView joinOrg(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("viewOrgs");
        
        mav.addObject( "message", "join org FAIL" );
 
        
        List<User> userList = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() );
        
        
        if ( userList.size() > 0 ) {
            User usr = userList.get(0);
            
            String orgId = req.getParameter("orgId");
            Org org = orgService.findOrg("orgId", orgId ).get(0);
            Set<Org> orgSet = usr.getOrgs();
            
            try {
                orgSet.add( org );
                //usr.setOrgs( orgSet );
                userService.updateUser(usr);
                mav.addObject( "message", "join org successful" );
            } catch (Exception e) {
                mav.addObject( "message", "you already joined this org" );
            }
        }
        

        String orgId = req.getParameter("orgId");
        Org org = orgService.findOrg("orgId", orgId ).get(0);
        Set<User> userSet = org.getMembers();
        
        User usr = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() ).get(0);
            
        try {
            userSet.add( usr );
            org.setMembers(userSet);
            orgService.updateOrg(org);
            mav.addObject( "message", "join org successful" );
        } catch (Exception e) {
            mav.addObject( "message", "you already joined this org" );
        }
       
        return mav;
        
    }

    
    @RequestMapping("/viewMembers.htm")
    public ModelAndView viewMembers(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("viewMembers");
        
        //mav.addObject( "message", "No Members" );
 
        Set<User> memberList = new LinkedHashSet<User>();

        String orgId = req.getParameter("orgId");
        Org org = orgService.findOrg("orgId", orgId ).get(0);
        memberList = org.getMembers();
        
        mav.addObject( "memberList", memberList );
        
        System.out.println( "A >>>>>>>>>> " + orgId );
        System.out.println( "B >>>>>>>>>> " + memberList );
        
        return mav;
    }
    
    @RequestMapping("/deleteOrg.htm")
    public ModelAndView deleteOrg(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("viewOrgs");
        
        mav.addObject( "message", "Org DELETED" );
 
        Set<User> memberList = new LinkedHashSet<User>();

        Long orgId = Long.parseLong( req.getParameter("orgId") );
        orgService.deleteOrg( orgId );
  
        System.out.println( "orgId >>>>>>>>>> " + memberList );
        
        return mav;
    }
    
}
*/