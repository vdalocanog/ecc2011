package exist.practice.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exist.practice.Org;
import exist.practice.service.OrgService;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/practiceProject-test-config.xml" })
public class OrgServiceImplMockTest {
	private OrgService orgService;
	
	//not necessary 'coz we are already mocking it
	/*
	@Autowired
	public void setOrgServiceImpl(OrgService orgService) {
		this.orgService = orgService;
	}
	*/
	
	 @Test
	 public void testExample() {
	  OrgService orgService = mock(OrgService.class);

	  verify(orgService, never()).findAllOrg();
      when(orgService.findAllOrg()).thenReturn( new ArrayList<Org>() );
      List<Org> orgList1 = orgService.findAllOrg();
      verify(orgService, times(1)).findAllOrg(); 
      assertNotNull(orgList1);
	  
	  verify(orgService, never()).addOrg(any(Org.class));
	  when(orgService.addOrg(any(Org.class))).thenReturn(true);
	  Org org1 = new Org();
      org1.setOrgName("testService-orgname1");
      boolean added = orgService.addOrg(org1);
	  verify(orgService, times(1)).addOrg(any(Org.class)); 
	  assertTrue(added);
	  
	  verify(orgService, never()).updateOrg(any(Org.class));
      when(orgService.updateOrg(any(Org.class))).thenReturn(true);
      Org org2 = new Org();
      org2.setOrgName("testService-orgname2");
      boolean updated = orgService.updateOrg(org2);
      verify(orgService, times(1)).updateOrg(any(Org.class)); 
      assertTrue(updated);
      
      verify(orgService, never()).deleteOrg( 1, Org.class );//to fix
      when(orgService.deleteOrg(1, Org.class)).thenReturn(true);
      boolean deleted = orgService.deleteOrg(1, Org.class);
      verify(orgService, times(1)).deleteOrg(1, Org.class); 
      assertTrue(deleted);
      
      verify(orgService, never()).findOrg(any(String.class), any(String.class), any(String.class));
      when(orgService.findOrg(any(String.class), any(String.class), any(String.class))).thenReturn( new ArrayList<Org>() );
      List<Org> orgList2 = orgService.findOrg("Org", "orgName", "math club");
      verify(orgService, times(1)).findOrg(any(String.class), any(String.class), any(String.class)); 
      assertNotNull(orgList2);
      
	 }

}
