package exist.practice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import exist.practice.Org;
import exist.practice.User;
import exist.practice.service.OrgService;
import exist.practice.service.UserService;

@Controller
@SessionAttributes({ "user" })
public class MainMultiController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private UserService userService;
	
	private OrgService orgService;

	@Autowired
	@Qualifier("sessionRegistry")
	private SessionRegistryImpl sessionRegistry;

	public void setSessionRegistryImpl(SessionRegistryImpl sessionRegistryImpl) {
		this.sessionRegistry = sessionRegistryImpl;
	}

	public void setUserServiceImpl(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    @Autowired
    public void setOrgService(OrgService orgService) {
        this.orgService = orgService;
    }

	@RequestMapping("/home.htm")
	public String home(HttpServletRequest req, ModelMap model) {
		HttpSession session = req.getSession();
		/*
		 * session.setAttribute("uname",
		 * SecurityContextHolder.getContext().getAuthentication().getName() );
		 * String uname = (String) session.getAttribute("uname");
		 * model.put("uname", uname);
		 */

		logger.debug("Total logged in users:"
				+ sessionRegistry.getAllPrincipals().size());
		if (session != null) {
			logger.debug("Session is not null");
			SessionInformation info = sessionRegistry
					.getSessionInformation(session.getId());
			String username = (String) info.getPrincipal();
			User user = (User) userService.findUser("userName", username).get(0);
			logger.debug("Username:" + user.getUserName());
			logger.debug("E-mail:" + user.getEmailAddress());
			model.put("user", user);
		}
		return "home";
	}

	@RequestMapping(value = "/admin/admin.htm", method = RequestMethod.GET)
	public String loadAdminPage() {
		return "admin";
	}

	@RequestMapping("/viewUser.htm")
	public String viewUser(HttpServletRequest req, ModelMap model) {
		/*
		 * HttpSession session = req.getSession(); String uname = (String)
		 * session.getAttribute("uname"); model.put("user",
		 * userService.findUser("userName", uname).get(0));
		 */
		return "viewProfile";
	}
	
	@RequestMapping("/viewProfile.htm")
    public ModelAndView viewProfile(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("viewProfile");
        
        User user = new User();

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
    
    @RequestMapping("/searchOrgs.htm")
    public ModelAndView searchOrgs(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("searchOrgs");
 
        /*
        List<Org> orgList = new ArrayList<Org>();
        orgList = orgService.findAllOrg();
        
        mav.addObject( "orgList", orgList );
        */
        
        return mav;
    }
    
    @RequestMapping("/searchUsers.htm")
    public ModelAndView searchUsers(HttpServletRequest req, HttpServletResponse res) throws Exception {
        ModelAndView mav = new ModelAndView("searchUsers");
        
        return mav;
    }
    
    /*
    @RequestMapping(value = "/getOrgList.htm", method = RequestMethod.POST)
    public @ResponseBody String getOrgList(HttpServletRequest req, HttpServletResponse res) throws Exception {
 
        System.out.println("RECEIVED: " + req.getParameter( "searchee" ));
        
        List<Org> orgList = new ArrayList<Org>();
        orgList = orgService.findOrgs("orgName", req.getParameter( "searchee" ) );
        
        return orgList.toString();
    }
    */
    
    @RequestMapping(value = "/getOrgList.htm", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getOrgList(@RequestParam String searchee) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        System.out.println("RECEIVED: " + searchee );
        
        List<Org> orgList = new ArrayList<Org>();
        orgList = orgService.findOrgs("orgName", searchee );
        map.put("orgList", orgList);
        
        List<String> orgNameList = new ArrayList<String>();
        for (Org org : orgList) {
            orgNameList.add(org.getOrgName());
        }
        map.put("orgNameList", orgNameList);
        
        return map;
    }
    
    @RequestMapping(value = "/getUserList.htm", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getUserList(@RequestParam String searchee) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        
        System.out.println("RECEIVED: " + searchee );
        
        List<User> userList = new ArrayList<User>();
        userList = userService.findUsers("userName", searchee );
        map.put("userList", userList);
        
        List<String> userNameList = new ArrayList<String>();
        for (User user : userList) {
            userNameList.add(user.getUserName());
        }
        map.put("userNameList", userNameList);
        
        return map;
    }

}
