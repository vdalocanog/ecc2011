package exist.practice.validator;

import org.testng.Assert;
import org.testng.annotations.*;
 
/**
 * Username validator Testing
 *
 */
public class UsernameValidatorTest {
 
	private UsernameValidator usernameValidator;
 
	@BeforeClass
    public void initData(){
		usernameValidator = new UsernameValidator();
    }
 
	@DataProvider
	public Object[][] ValidUsernameProvider() {
		return new Object[][]{
				{new String[] {
						"uname13", "uname_1990","uname-1990" ,"un3-4_ame"
				}}
		};
	}
 
	@DataProvider
	public Object[][] InvalidUsernameProvider() {
		return new Object[][]{
				{new String[] {
						"un","un@ame","uname123456789_-"	  
				}}
		};
	}
 
	@Test(dataProvider = "ValidUsernameProvider")
	public void ValidUsernameTest(String[] Username) {
		for(String temp : Username){
		   boolean valid = usernameValidator.validate(temp);
		   System.out.println("Username is valid : " + temp + " , " + valid);
		   Assert.assertEquals(true, valid);
		}
	}
 
	@Test(dataProvider = "InvalidUsernameProvider", 
                 dependsOnMethods="ValidUsernameTest")
	public void InValidUsernameTest(String[] Username) {
		for(String temp : Username){
			boolean valid = usernameValidator.validate(temp);
			System.out.println("username is valid : " + temp + " , " + valid);
			Assert.assertEquals(false, valid);
		}
	}	
}