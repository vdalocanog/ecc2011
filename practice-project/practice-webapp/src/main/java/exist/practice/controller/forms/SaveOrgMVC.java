package exist.practice.controller.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import exist.practice.Org;
import exist.practice.service.OrgService;

import  org.apache.log4j.Logger;

@Controller
@RequestMapping("/saveOrg.htm")
public class SaveOrgMVC {
    
    private OrgService orgService;
    
    protected static  Logger logger = Logger.getLogger("controller");
    
    @Autowired
    public void setOrgServiceImpl(OrgService orgService) {
        this.orgService = orgService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap model, HttpServletRequest req) {
        System.out.println("Invoked: showForm");
        model.put("org", new Org());
        return "saveOrg";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String onSubmit(HttpServletRequest req, ModelMap model, Org org) {
        System.out.println("Invoked: onSubmit");
        String error = "Org Registration Failed! ";
        if( (org.getOrgName()!=null) && !org.getOrgName().trim().equals("") ) {

            orgService.addOrg(org);  
            HttpSession session = req.getSession();
            session.setAttribute("oname", org.getOrgName());
            error = "Org '" + org.getOrgName() + "' Registration Successful! ";
            //return "redirect: home.htm";

        } else error += "Make sure to fill-up all required fields.";
        
        error = "received: " + ;

        return error;
    }
    /*
    public String onSubmit(HttpServletRequest req, ModelMap model, Org org) {
        System.out.println("Invoked: onSubmit");
        String error = "Org Registration Failed! ";
        if( (org.getOrgName()!=null) && !org.getOrgName().trim().equals("") ) {

            orgService.addOrg(org);  
            HttpSession session = req.getSession();
            session.setAttribute("oname", org.getOrgName());
            error = "Org " + org.getOrgName() + " Registration Successful! ";
            //return "redirect: home.htm";

        } else error += "Make sure to fill-up all required fields.";
        model.put("message", error);
        return "saveOrg";
    } 
    */  
    
}
