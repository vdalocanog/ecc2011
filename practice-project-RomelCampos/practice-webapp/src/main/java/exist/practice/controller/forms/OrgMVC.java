package exist.practice.controller.forms;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import exist.practice.Org;
import exist.practice.User;
import exist.practice.service.OrgService;
import exist.practice.service.UserService;
import exist.practice.validator.UsernameValidator;

@Controller
@SessionAttributes({ "status" })
public class OrgMVC {
	
	UsernameValidator onameValidator;
	
	public OrgMVC(){
		onameValidator = new UsernameValidator();
	}
	
	@Autowired
	private UserService userService;
	@Autowired
	private OrgService orgService;
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @param orgService the orgService to set
	 */
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	
	@RequestMapping(value="org.htm")
	public String loadOrg(HttpServletRequest req, ModelMap model) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		model.put("orgList", userService.findUser("userName", user.getUserName()).get(0).getOrgs());
		model.put("status", "org");
		return "orgForm";
	}
	
	@RequestMapping(value="manageOrgs.htm")
	public String loadManageOrgs(ModelMap model){
		model.put("org", new Org());
		model.put("orgList", orgService.findAllOrg());
		return "manageOrgsForm";
	}
	
	@RequestMapping(value="/addOrg")
	public @ResponseBody String addOrg(@RequestParam String orgName){
		if(onameValidator.validate(orgName)
			&& isAvailable(orgName)
			&& orgService.addOrg(new Org(orgName))) return "Org created.";
		return "Org not created.";
	}
	
	@RequestMapping(value="listAllOrgs.htm")
	public String loadListAllOrgs(HttpServletRequest req, ModelMap model){
		User user = (User) req.getSession().getAttribute("user");
		model.put("orgList", orgService.findAllOrg());
		model.put("userId", userService.findUser("userName", user.getUserName()).get(0).getUserId());
		return "listAllOrgs";
	}
	
	public boolean isAvailable(String oname){
		if(orgService.findOrg("orgName", oname).size() == 0) return true;
		return false;
	}
	
	@RequestMapping(value="/checkOname")
	public @ResponseBody String checkOname(@RequestParam String orgName){
		if(!onameValidator.validate(orgName)) return "notOk";
		/*for(int i=0; i<orgName.length(); i++){
			if(orgName.charAt(i) == '\''){
				orgName = new StringBuffer(orgName).insert(i, "\\").toString();
				System.out.println(orgName);
				break;
			}
		}*/
		if(!isAvailable(orgName)) return "notOk";
		return "isOk";
	}
	
	@RequestMapping(value = "/userJoinOrg", method = RequestMethod.GET)
	public @ResponseBody String userJoinOrg(@RequestParam String userID, @RequestParam String orgID) {
		Org org = orgService.findOrg("orgId", orgID).get(0);
		Set<User> members = org.getMembers();
		for(User i : members){
			System.out.println(i.getUserId() + " == " + Integer.parseInt(userID));
			if(i.getUserId() == Integer.parseInt(userID)) return "Already a member";
		}
		members.add(userService.findUser("userId", userID).get(0));
		orgService.updateOrg(org);
		return "Successful.";
	}	
	
	@RequestMapping(value="viewMembers.htm")
	public String loadMembers(ModelMap model, @RequestParam(value = "orgID") String id){
		model.put("orgMembers", orgService.findOrg("orgId", id).get(0).getMembers());
		return "viewMembersForm";
	}
}
