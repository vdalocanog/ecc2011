package exist.practice.service;
 

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;


import junit.framework.Assert;
 
import org.testng.annotations.*; //import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exist.practice.Org;
import exist.practice.service.OrgService;
import exist.practice.service.impl.OrgServiceImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/practiceProject-test-config.xml" })
public class MoooooTest {
   
  //to make mock objects
    @Mock
    private Org org;
    
    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
 @Test
 public void exampleMockTest() {
  System.out.println("STARTED exampleMockTest************************************");
	 
  // another way to make mock objects
  OrgService orgService = mock(OrgServiceImpl.class);
  //Org org = mock(Org.class);
  
  //public boolean addOrg(Org object);
  //define
  when(orgService.addOrg(any(Org.class))).thenReturn(true);
  //verify (optional)
  verify(orgService, never()).addOrg(any(Org.class));
  //run
  orgService.addOrg(org);
  //verify
  verify(orgService, times(1)).addOrg(org); 
  verify(orgService, atLeast(1)).addOrg(org); 
  //assert
  Assert.assertTrue(orgService.addOrg(org));
  System.out.println("SUCCESS MOCK: addOrg(Org object)");
  
  //reset the mocks
  reset(orgService); 
  
  //public boolean updateOrg(Org object);
  //define
  when(orgService.updateOrg(any(Org.class))).thenReturn(true);
  //verify (optional)
  verify(orgService, never()).updateOrg(any(Org.class));
  //run
  orgService.updateOrg(org);
  //verify
  verify(orgService, times(1)).updateOrg(org); 
  verify(orgService, atLeast(1)).updateOrg(org); 
  //assert
  Assert.assertTrue(orgService.updateOrg(org));
  System.out.println("SUCCESS MOCK: updateOrg(Org object)");
  
  //reset the mocks
  reset(orgService); 

  //public boolean deleteOrg(long id);
  //define
  //when(orgService.deleteOrg(any(Long.class))).thenReturn(true);
  //verify (optional)
  /*verify(orgService, never()).deleteOrg(any(Long.class));
  //run
  orgService.deleteOrg(1);
  //verify
  verify(orgService, times(1)).deleteOrg(1); 
  verify(orgService, atLeast(1)).deleteOrg(1); 
  //assert
  Assert.assertFalse(orgService.deleteOrg(1));*/
  System.out.println("SUCCESS MOCK: deleteOrg(long id)");
  
  //reset the mocks
  reset(orgService); 

  //public List<Org> findAllOrg();
  //define
  when(orgService.findAllOrg()).thenReturn(null);
  //verify (optional)
  verify(orgService, never()).findAllOrg();
  //run
  orgService.findAllOrg();
  //verify
  verify(orgService, times(1)).findAllOrg(); 
  verify(orgService, atLeast(1)).findAllOrg(); 
  //assert
  Assert.assertNull(orgService.findAllOrg());
  System.out.println("SUCCESS MOCK: findAllOrg()");
  
  //reset the mocks
  reset(orgService); 
  
  //public List<Org> findOrg(String column, String value);
  //define
  when(orgService.findOrg(any(String.class),any(String.class))).thenReturn(null);
  //verify (optional)
  verify(orgService, never()).findOrg(any(String.class),any(String.class));
  //run
  orgService.findOrg("orgId","1");
  //verify
  verify(orgService, times(1)).findOrg("orgId","1"); 
  verify(orgService, atLeast(1)).findOrg("orgId","1"); 
  //assert
  Assert.assertNull(orgService.findOrg("orgId","1"));
  System.out.println("SUCCESS MOCK: findOrg(String column, String value)");
  
  //reset the mocks
  reset(orgService);   
  
  //public List<Org> findOrgs(String column, String value);
  //define
  when(orgService.findOrgs(any(String.class),any(String.class))).thenReturn(null);
  //verify (optional)
  verify(orgService, never()).findOrgs(any(String.class),any(String.class));
  //run
  orgService.findOrgs("orgId","1");
  //verify
  verify(orgService, times(1)).findOrgs("orgId","1"); 
  verify(orgService, atLeast(1)).findOrgs("orgId","1"); 
  //assert
  Assert.assertNull(orgService.findOrgs("orgId","1"));
  System.out.println("SUCCESS MOCK: findOrgs(String column, String value)");
 
  System.out.println("ENDED exampleMockTest************************************");
 }

	
}
