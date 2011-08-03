package exist.practice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import exist.practice.User;
import exist.practice.service.UserService;

@Controller
@SessionAttributes({ "user", "status" })
public class MainMultiController {

	protected static Logger logger = Logger.getLogger("controller");

	@Autowired
	private UserService userService;

	@Autowired
	@Qualifier("sessionRegistry")
	private SessionRegistryImpl sessionRegistry;

	public void setSessionRegistryImpl(SessionRegistryImpl sessionRegistryImpl) {
		this.sessionRegistry = sessionRegistryImpl;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/home.htm")
    public String home(HttpServletRequest req, ModelMap model){
		HttpSession session = req.getSession();
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
    public String viewUser(HttpServletRequest req, ModelMap model){
		model.put("status", "viewUser");
    	return "viewProfile";
    }
}
