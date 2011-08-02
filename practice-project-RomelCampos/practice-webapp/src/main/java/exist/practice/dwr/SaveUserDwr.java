
package exist.practice.dwr;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

//import com.exist.ecc.models.User;
//import com.exist.ecc.services.UserService;
//import com.exist.ecc.utils.PostOffice;

@Service
@RemoteProxy(name="SaveUserDwr")
public class SaveUserDwr
{

	//private UserService userService;
	
	//@Autowired
	//public void setUserService(UserService userService) {
	//	this.userService = userService;
	//}

	
	@RemoteMethod
    public Map<String, String> verifyUserName( String userNameF ) {
        Map<String,String> reply = new HashMap<String,String>();
      
        reply.put("userNameMessage", "");

        if ( (userNameF == null) || (userNameF.trim().equals("")) ) {
        	reply.put("userNameMessage", "user name required.");
        } else if (userNameF.trim().contains(" ")) {
            reply.put("userNameMessage", "user name should not contain spaces.");
        } else if (userNameF.trim().equals("samplename")) {
            reply.put("userNameMessage", "user name already taken");
        } else {
            //if username is ok, continue checking the other fields
        }
 		
        return reply;
    }
	
	//can be done in client page, i.e. standard javascript
	public boolean isValidEmailAddress(String emailAddress){
		if(emailAddress==null){
			return false;
		}
		boolean status = false;
		emailAddress = emailAddress.trim();
		
	      //Set the pattern string
	      Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

	      //Match the given string with the pattern
	      Matcher m = p.matcher(emailAddress);

	      //check whether match is found 
	      boolean matchFound = m.matches();
	      
		if( (!emailAddress.equals("")) && (matchFound) ){
			status = true;
		}
		
		return status;
	}
	

	public Date generateDate(String year, String month, String day){
		
		if( (year==null) || (year.equals("")) ){
			year = "0";
		}
		
		if( (month==null) || (month.equals("")) ){
			month = "0";
		}
		
		if( (day==null) || (day.equals("")) ){
			day = "0";
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.set( Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day) );
		return calendar.getTime();
	}
	

	public boolean isValidContactNumber(String contactNumber){
		if(contactNumber==null){
			return false;
		}
		boolean status = false;
		contactNumber = contactNumber.trim();
		
	      //Set the pattern string
	      Pattern p = Pattern.compile("[0-9]+");

	      //Match the given string with the pattern
	      Matcher m = p.matcher(contactNumber);

	      //check whether match is found 
	      boolean matchFound = m.matches();
	      
		if( (!contactNumber.equals("")) && (matchFound) ){
			status = true;
		}
		
		return status;
	}
	
}
