
package exist.practice.dwr;

/*
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

import com.exist.ecc.models.User;
import com.exist.ecc.services.UserService;
import com.exist.ecc.utils.PostOffice;

@Service
@RemoteProxy(name="UserLookup")
*/
public class UserLookup
{

    /*
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	@RemoteMethod
    public Map<String, String> verifyVoter(
    		String voterIdF, 
    		String firstNameF, 
    		String middleNameF, 
    		String lastNameF, 
    		String birthdateF, 
    		String emailF) {
		//should be real tim
        Map<String,String> reply = new HashMap<String,String>();
        
        int voterId = -1;
        
        String firstName = firstNameF.trim();
        String middleName = middleNameF.trim();
        String lastName = lastNameF.trim();
        
        String birthdate = birthdateF.trim();
        String email = emailF.trim();
        
        boolean isValid = true;
        
        User user = null;
        
        reply.put("voterIdMessage", "");
        
        reply.put("firstNameMessage", "");
        reply.put("middleNameMessage", "");
        reply.put("lastNameMessage", "");
        
        reply.put("birthdateMessage", "");
        reply.put("emailMessage", "");
        reply.put("confirmationForm", "" );
        
        
        if ( (voterIdF == null) || (voterIdF.trim().equals("")) ) {
        	reply.put("voterIdMessage", "Voter ID required.");
        	isValid = false;
        } else {
        	
        	try {
        		voterId = Integer.parseInt( voterIdF.trim() );
        		user = userService.loadVoter(voterId);
        	} catch (Exception e) {
        		user = null;
        	}
        	
        	if ( user == null ) {
            	reply.put("voterIdMessage", "Invalid voter ID.");
            	isValid = false;
    		} else if ( user.getStatus() == 4 ) { 
    			reply.put("voterIdMessage", "This voter ID has already voted.");
    			isValid = false;
    		} else {
            
    	        if ( !user.getFirstName().equals(firstName) ) {
    	        	reply.put("firstNameMessage", "Invalid first name.");
    	        	isValid = false;
    			}
    	        
    	        if ( !user.getMiddleName().equals(middleName) ) {
    	        	reply.put("middleNameMessage", "Invalid middle name.");
    	        	isValid = false;
    			}
    	        
    	        if ( !user.getLastName().equals(lastName) ) {
    	        	reply.put("lastNameMessage", "Invalid last name.");
    	        	isValid = false;
    			}
    	        
    	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    	        try {
    				if ( !user.getBirthdate().equals(df.parse(birthdate)) ) {
    					reply.put("birthdateMessage", "Invalid birthdate.");
    					isValid = false;
    				}
    			} catch (ParseException e) {
    				reply.put("birthdateMessage", "Invalid birthdate.");
					isValid = false;
    				e.printStackTrace();
    			}
    	        
    	        if ( (email==null) || (email.equals("")) ) {
    	        	reply.put("emailMessage", "Email Required.");
    	        	isValid = false;
    			} else if ( !(this.isValidEmailAddress(email)) ) {
    				reply.put("emailMessage", "Invalid Email Format.");
    	        	isValid = false;
    			} else {
    				//user.setEmailAddress(email);
    			}
            
    		}
        	
        }
        
        if(isValid){
        	reply.put("confirmationForm", "send email" );
        } else {
        	reply.put("confirmationForm", "" );
        }
 		
        return reply;
    }
	
	
	@RemoteMethod
    public Map<String, String> sendEmail(
    		String voterIdF, 
    		String firstNameF, 
    		String middleNameF, 
    		String lastNameF, 
    		String birthdateF, 
    		String emailF) {
		//should be real tim
        Map<String,String> reply = new HashMap<String,String>();
        
        int voterId = -1;
        
        String firstName = firstNameF.trim();
        String middleName = middleNameF.trim();
        String lastName = lastNameF.trim();
        
        String birthdate = birthdateF.trim();
        String email = emailF.trim();
        
        boolean isValid = true;
        
        User user = null;
        
        reply.put("voterIdMessage", "");
        
        reply.put("firstNameMessage", "");
        reply.put("middleNameMessage", "");
        reply.put("lastNameMessage", "");
        
        reply.put("birthdateMessage", "");
        reply.put("emailMessage", "");
        reply.put("confirmationForm", "" );
        
        
        if ( (voterIdF == null) || (voterIdF.trim().equals("")) ) {
        	reply.put("voterIdMessage", "Voter ID required.");
        	isValid = false;
        } else {
        	
        	try {
        		voterId = Integer.parseInt( voterIdF.trim() );
        		user = userService.loadVoter(voterId);
        	} catch (Exception e) {
        		user = null;
        	}
        	
        	if ( user == null ) {
            	reply.put("voterIdMessage", "Invalid voter ID.");
            	isValid = false;
    		} else if ( user.getStatus() == 4 ) { 
    			reply.put("voterIdMessage", "This voter ID has already voted.");
    			isValid = false;
    		} else {
            
    	        if ( !user.getFirstName().equals(firstName) ) {
    	        	reply.put("firstNameMessage", "Invalid first name.");
    	        	isValid = false;
    			}
    	        
    	        if ( !user.getMiddleName().equals(middleName) ) {
    	        	reply.put("middleNameMessage", "Invalid middle name.");
    	        	isValid = false;
    			}
    	        
    	        if ( !user.getLastName().equals(lastName) ) {
    	        	reply.put("lastNameMessage", "Invalid last name.");
    	        	isValid = false;
    			}
    	        
    	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    	        try {
    				if ( !user.getBirthdate().equals(df.parse(birthdate)) ) {
    					reply.put("birthdateMessage", "Invalid birthdate.");
    					isValid = false;
    				}
    			} catch (ParseException e) {
    				reply.put("birthdateMessage", "Invalid birthdate.");
					isValid = false;
    				e.printStackTrace();
    			}
    	        
    	        if ( (email==null) || (email.equals("")) ) {
    	        	reply.put("emailMessage", "Email Required.");
    	        	isValid = false;
    			} else if ( !(this.isValidEmailAddress(email)) ) {
    				reply.put("emailMessage", "Invalid Email Format.");
    	        	isValid = false;
    			} else {
    				//user.setEmailAddress(email);
    			}
            
    		}
        	
        }
 
       
        if(isValid){
        	
        	
        	//String confirmationCode =  userService.generateConfirmationCode(user.getVoterId());
	    	//String link = "http://127.0.1.1:8080/webAppMiniProj/ballot.htm?voterId="+user.getVoterId()+"&confirmationCode="+confirmationCode;
        	//try { System.out.println("sleeping..."); Thread.sleep(10000); reply.put("confirmationForm", "LINK:\n"+link ); } catch (InterruptedException e) { }
			
        	
        	reply.put("confirmationForm",  sendBallotLink(user, email) );
			
        } else {
        	reply.put("confirmationForm", "" );
        }
        
        System.out.println("------------------------------------------------------\n\n");
 		
        return reply;
    }

	
	

	private String sendBallotLink(User user, String email) {
		System.out.println("creating link...");
		
		try {
			
			String thisIp = getIpAddress();
		
	    	String sender = "from_user@domain.com";
	    	String receiver = email;
	    	String subject = "ECC Election - Ballot Link - "+ java.util.Calendar.getInstance().getTime();
	    	String confirmationCode =  userService.generateConfirmationCode(user.getVoterId());
	    	//String link = "http://"+thisIp+":8080/view/ballot.htm?voterId="+user.getVoterId()+"&confirmationCode="+confirmationCode;
		String link = "http://192.168.245.81:8181/ECCFinalProject/ballot.htm?voterId="+user.getVoterId()+"&confirmationCode="+confirmationCode;
	    	String content = "Hello " + user.getFirstName() + " " + user.getMiddleName() + " " + user.getLastName() + ". \n\n " +
	    			"Here is the link to your ballot: \n\n " + 
	    			link;
	    	
	    	userService.setEmailedVoter(user.getVoterId());
	
	    	System.out.println("Email will now be sent.");
	    	
	    	ApplicationContext context = new ClassPathXmlApplicationContext("springMail.xml");
	    	
	    	PostOffice postOffice = (PostOffice) context.getBean("postOffice");
	    	
	    	postOffice.sendMail(sender, receiver, subject, content);
	    	
	    	return "Ballot link <br /> has been sent to: <br /> <b>" + email + "</b>";
    	
		} catch(Exception e) {
			e.printStackTrace();
			return "Fail sending ballot link to: " + email;
		}
		
	}


	private String getIpAddress() throws UnknownHostException {
		
		String hostName;
		String thisIp = "UNKNOWN";
		
		hostName = InetAddress.getLocalHost().getHostName();
		
		InetAddress addrs[] = InetAddress.getAllByName(hostName);
		 
		 for (InetAddress addr: addrs) {
			 System.out.println ("addr.getHostAddress() = " + addr.getHostAddress());
			 System.out.println ("addr.getHostName() = " + addr.getHostName());
			 System.out.println ("addr.isAnyLocalAddress() = " + addr.isAnyLocalAddress());
			 System.out.println ("addr.isLinkLocalAddress() = " + addr.isLinkLocalAddress());
			 System.out.println ("addr.isLoopbackAddress() = " + addr.isLoopbackAddress());
			 System.out.println ("addr.isMulticastAddress() = " + addr.isMulticastAddress());
			 System.out.println ("addr.isSiteLocalAddress() = " + addr.isSiteLocalAddress());
			 System.out.println ("");
		
			 if (!addr.isLoopbackAddress() && addr.isSiteLocalAddress()) {
				 thisIp = addr.getHostAddress();
			 }
		 }
	
		return thisIp;
	}



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
	*/
	
	
}
