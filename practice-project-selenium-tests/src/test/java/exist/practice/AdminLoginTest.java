package exist.practice;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

import junit.framework.Assert;

public class AdminLoginTest extends SeleneseTestCase {
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testAdminLogin() throws Exception {
	    selenium.setSpeed("1000");
	    
		selenium.open("/practice-webapp/auth/login.htm?error=true");
		selenium.type("id=username", "gg");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		//assertTrue(selenium.isTextPresent("Invalid Credentials"));
		assertTrue(selenium.getText("css=#error").equals("Invalid Credentials"));
		
		selenium.open("/practice-webapp/auth/login.htm?error=true");
		selenium.type("id=username", "admin");
		selenium.type("id=password", "qwer");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getText("css=#error").equals("Invalid Credentials"));
		
		selenium.open("/practice-webapp/auth/login.htm?error=true");
		selenium.type("id=username", "admin");
		selenium.type("id=password", "admin");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.getText("css=h1").equals("Welcome"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
