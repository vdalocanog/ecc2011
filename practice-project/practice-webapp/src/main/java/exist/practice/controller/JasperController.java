package exist.practice.controller;

import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;

import org.apache.log4j.Logger;
import exist.practice.dao.SalesDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles and retrieves download request
 */
@Controller
@RequestMapping("/report")
public class JasperController {

	protected static Logger logger = Logger.getLogger("controller");
	
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
    	return "downloadReport";
	}
 
    /**
     * Retrieves the download file in XLS format
     * 
     * @return
     */
    @RequestMapping(value = "/download/xls", method = RequestMethod.GET)
    public ModelAndView doSalesReportXLS(ModelAndView modelAndView) 
		 {
		logger.debug("Received request to download Excel report");
		
		// Retrieve our data from a custom data provider
		// Our data comes from a DAO layer
		SalesDAO dataprovider = new SalesDAO();
		
		// Assign the datasource to an instance of JRDataSource
		// JRDataSource is the datasource that Jasper understands
		// This is basically a wrapper to Java's collection classes
		JRDataSource datasource  = dataprovider.getDataSource();
		
		// In order to use Spring's built-in Jasper support, 
		// We are required to pass our datasource as a map parameter
		// parameterMap is the Model of our application
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", datasource);
		
		// xlsReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		modelAndView = new ModelAndView("xlsReport", parameterMap);
		
		// Return the View and the Model combined
		return modelAndView;
	}
    
    /**
     * Retrieves the download file in XLS format
     * 
     * @return
     */
    @RequestMapping(value = "/download/pdf", method = RequestMethod.GET)
    public ModelAndView doSalesReportPDF(ModelAndView modelAndView) 
		 {
		logger.debug("Received request to download PDF report");
		
		// Retrieve our data from a custom data provider
		// Our data comes from a DAO layer
		SalesDAO dataprovider = new SalesDAO();
		
		// Assign the datasource to an instance of JRDataSource
		// JRDataSource is the datasource that Jasper understands
		// This is basically a wrapper to Java's collection classes
		JRDataSource datasource  = dataprovider.getDataSource();
		
		// In order to use Spring's built-in Jasper support, 
		// We are required to pass our datasource as a map parameter
		// parameterMap is the Model of our application
		Map<String,Object> parameterMap = new HashMap<String,Object>();
		parameterMap.put("datasource", datasource);
		
		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		modelAndView = new ModelAndView("pdfReport", parameterMap);
		
		// Return the View and the Model combined
		return modelAndView;
	}

}
