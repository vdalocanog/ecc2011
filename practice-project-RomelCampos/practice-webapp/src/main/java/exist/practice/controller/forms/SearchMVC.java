package exist.practice.controller.forms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exist.practice.Org;
import exist.practice.User;
import exist.practice.service.OrgService;
import exist.practice.service.UserService;

@Controller
@RequestMapping(value="/search")
public class SearchMVC {
	
	private UserService userService;
	private OrgService orgService;
	
	/**
	 * @param orgService the orgService to set
	 */
	@Autowired
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}

	/**
	 * @param userservice the userservice to set
	 */
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/index.htm")
	public String loadSearchHome(HttpServletRequest req, ModelMap map){
		req.getSession().setAttribute("status", "");
		return "searchHome";
	}
	
	@RequestMapping(value="/data.htm", method=RequestMethod.GET)
	public String loadSearchSuggestions(ModelMap map,
			@RequestParam(value = "data") String finData,
			@RequestParam(value = "cat") String searchBy,
			@RequestParam(value = "id") String searchId)
	{
		if(searchId.equals("searchUser")){	
			List<User> users; 
			if(searchBy.equals("Name")){
				users = userService.searchUser("fullName", finData);
			} else if(searchBy.equals("Address")){
				users = userService.searchUser("homeAddress", finData);
				map.put("flag", "address");
			} else {
				users = null;
				map.put("flag", "hideSug");
			}
			map.put("userList", users);
		} else {
			List<Org> orgs = orgService.findOrg("orgName", finData); 
			map.put("flag", "org");
			map.put("orgList", orgs);
		}
		return "searchSuggestions";
	}
	
	@RequestMapping(value = "/viewResult.htm")
	public String loadresult(ModelMap map,
			@RequestParam(value="searchID")String searchID,
			@RequestParam(value="finData")String finData)
	{
		if(searchID.equals("searchUser")){
			try{
				User user = userService.findUser("fullName", finData).get(0);
				map.put("user", user);
			} catch(Exception e){
				map.put("flag", "notFound");
			}
		} else {
			try{
				Org org = orgService.findOrg("orgName", finData).get(0);
				map.put("org", org);
			} catch (Exception e) {
				map.put("flag", "notFound");
			}
		}
		return "resultForm";
	}
}
