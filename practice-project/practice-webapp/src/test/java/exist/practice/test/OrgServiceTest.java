package exist.practice.test;
 
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
import junit.framework.Assert;
 
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import exist.practice.Org;
import exist.practice.service.OrgService;
import exist.practice.service.impl.OrgServiceImpl;
 
public class OrgServiceTest {
 //This test using mockito doesn't make sense yet. I don't feel well today.
    
    @Mock
    private Org org;
    //to make mock objects
    
    @Before 
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
 @Test
 public void testExample() {
  // another way to make mock objects
  OrgService orgService = mock(OrgServiceImpl.class);
 
  // run
  orgService.addOrg(org);
 
  // verify
  verify(orgService, times(1)).addOrg(any(Org.class)); // verify 1
  
  // invocation
  verify(orgService).deleteOrg(any(Long.class)); // verify 1
  // invocation, short syntax
 
  reset(orgService); // reset the mocks
 
  verify(orgService, never()).findOrg(anyString(), anyString());
 
  orgService.deleteOrg(any(Long.class));
  orgService.deleteOrg(any(Long.class));
 
  when(orgService.findAllOrg()).thenReturn(null);

  Assert.assertNull(orgService.findAllOrg());
  orgService.addOrg(null);
 }

}
