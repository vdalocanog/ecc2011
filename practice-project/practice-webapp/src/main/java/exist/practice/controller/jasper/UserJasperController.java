package exist.practice.controller.jasper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;

import exist.practice.Org;
import exist.practice.User;
import exist.practice.service.UserService;
//import exist.practice.dao.JasperDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles and retrieves download request
 */
@Controller
@RequestMapping("/report/user")
public class UserJasperController {

	protected static Logger logger = Logger.getLogger("controller");
	
	private UserService userService;
	
	@Autowired
    public void setUserServiceImpl(UserService userService) {
        this.userService = userService;
    }
	
	/**
	 * Handles and retrieves the download page
	 * 
	 * @return the name of the JSP page
	 */
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String getDownloadPage() {
    	logger.debug("Received request to show download page");
    
    	// Do your work here. Whatever you like
    	// i.e call a custom service to do your business
    	// Prepare a model to be used by the JSP page
    	
    	// This will resolve to /WEB-INF/jsp/downloadpage.jsp
    	return "downloadUserReport";
	}
    
    /**
     * Used to populate data -- main report
     * @return
     */
    public  JRDataSource getDataSource() {
        // Create an array list of User 
        List<User> items = new ArrayList<User>();

        // You can populate data from a custom JDBC or DAO layer
        items = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() );
        
        // Wrap the collection in a JRBeanCollectionDataSource
        // This is one of the collections that Jasper understands
        JRDataSource ds = new JRBeanCollectionDataSource(items);    
        
        // Return the wrapped collection
        return ds;
    }
    
    /**
     * Used to populate data -- sub report
     * @return
     */
    public  JRDataSource getSubDataSource() {
        // Create an array list of User 
        Set<Org> items = new LinkedHashSet<Org>();

        // You can populate data from a custom JDBC or DAO layer
        items = userService.findUser("userName", SecurityContextHolder.getContext().getAuthentication().getName() ).get(0).getOrgs();
        
        // Wrap the collection in a JRBeanCollectionDataSource
        // This is one of the collections that Jasper understands
        JRDataSource ds = new JRBeanCollectionDataSource(items);    
        
        // Return the wrapped collection
        return ds;
    }
    
    /**
     * 
     * @param modelAndView
     * @return collection of all data sources to be used by the report
     */
    private Map<String,Object> setUpDataSources(ModelAndView modelAndView) {
     // Retrieve our data from a custom data provider
        // Our data comes from a DAO layer
        //JasperDAO dataprovider = new JasperDAO();
        
        // Assign the datasource to an instance of JRDataSource
        // JRDataSource is the datasource that Jasper understands
        // This is basically a wrapper to Java's collection classes
        JRDataSource datasource  = this.getDataSource();
        JRDataSource subDatasource  = this.getSubDataSource();
        
        // In order to use Spring's built-in Jasper support, 
        // We are required to pass our datasource as a map parameter
        // parameterMap is the Model of our application
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        
        // We pass two datasources here:
        // "datasource" is used by the main report.
        // This is declared in the /WEB-INF/jasper-views.xml
         
        // "JasperCustomSubReportDatasource" is used by the sub-report
        // This is declared  in the master report named tree-template.jrxml
        // It is also declared in the /WEB-INF/jasper-views.xml
         
        // Both datasources use the same datasource
        // You can provide different datasources
        parameterMap.put("datasource", datasource);
        parameterMap.put("JasperCustomSubReportDatasource", subDatasource);
        
        return parameterMap;
    }
    
    /**
     * Retrieves the download file in XLS format
     * 
     * @return
     */
    @RequestMapping(value = "/download/report.xls", method = RequestMethod.GET)
    public ModelAndView doSalesReportXLS(ModelAndView modelAndView)  {
		logger.debug("Received request to download XLS report");
		
		Map<String,Object> parameterMap = setUpDataSources(modelAndView);
		
		// xlsUserReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		modelAndView = new ModelAndView("xlsUserReport", parameterMap);
		
		// Return the View and the Model combined
		return modelAndView;
	}
    
    /**
     * Retrieves the download file in PDF format
     * 
     * @return
     */
    @RequestMapping(value = "/download/report.pdf", method = RequestMethod.GET)
    public ModelAndView doSalesReportPDF(ModelAndView modelAndView)  {
        logger.debug("Received request to download PDF report");
        
        Map<String,Object> parameterMap = setUpDataSources(modelAndView);
        
        // pdfUserReport is the View of our application
        // This is declared inside the /WEB-INF/jasper-views.xml
        modelAndView = new ModelAndView("pdfUserReport", parameterMap);
        
        // Return the View and the Model combined
        return modelAndView;
    }

}
