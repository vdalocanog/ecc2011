package exist.practice.controller.auth;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exist.practice.User;
import exist.practice.service.UserService;

@Controller
@RequestMapping("/auth")
public class LoginLogOutController {

	protected static Logger logger = Logger
			.getLogger("login_logout_controller");

	@Autowired
	private UserService userService;

	@Autowired
	private SessionFactory sessionFactory;

	private static final String FLAT_XML_DATASET = "FlatXmlDataSet.xml";

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@SuppressWarnings("deprecation")
	private IDataSet getDataSet() throws Exception {
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream(FLAT_XML_DATASET);
		IDataSet dataset = new FlatXmlDataSet(inputStream);
		return dataset;

	}

	private IDatabaseConnection getConnection() throws Exception {
		Connection conn = SessionFactoryUtils.getDataSource(sessionFactory)
				.getConnection();
		IDatabaseConnection connection = new DatabaseConnection(conn);
		return connection;
	}

	private void loadData() throws DatabaseUnitException, SQLException,
			Exception {
		DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String loadLoginPage(
			@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "uname", required = false) String uname,
			@RequestParam(value = "info", required = false) String info,
			@RequestParam(value = "expired", required = false) boolean expired,
			HttpServletRequest req,
			ModelMap model) 
	{
		HttpSession session = req.getSession();
		if(session.getAttribute("user") == null){
			List<User> users = userService.findAllUser();
			if (users.size() == 0 || users == null) {
				try {
					this.loadData();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.debug("DbUnit Error:Start");
					e.printStackTrace();
					logger.debug("DbUnit Error");
				}
			}
			
			String msg = "Log In";
			if (error == true) msg = "Invalid Credentials";
			else if(expired == true) msg = "Session Expired";
			else if(info != null) msg = info;
			model.put("error", msg);
			model.put("uname", uname);
			return "login";
		} else {
			return "redirect: ../../../home.htm";
		}
		
	}

	@RequestMapping(value = "/accessdenied.htm", method = RequestMethod.GET)
	public String loadDeniedPage() {
		return "accessdenied";
	}
}
