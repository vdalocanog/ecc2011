package exist.practice.service;
 
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.*;
import org.testng.annotations.*;

import java.util.List;

import exist.practice.Org;
import exist.practice.service.OrgService;
import exist.practice.service.impl.OrgServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/practiceProject-test-config.xml" })
public class OrgServiceTest {
    /*
    private OrgService orgService;
    
    @Autowired
    public void setOrgService(OrgService orgService) {
        this.orgService = orgService;
        System.out.println("Excuted: setOrgService");
    }
    
    @BeforeClass
    public void setUp() {
      // code that will be invoked when this test is instantiated
      this.orgService = new OrgServiceImpl();
      System.out.println("Excuted: setUp");
    }
    
    @Test(groups = { "fast" })
    public void aFastTest() {
      System.out.println("BEGIN Fast test");
      
      Org org = new Org();
      //org.setOrgId(1);
      //org.setOrgName("yesss");
      System.out.println("-received: " + org);
      Assert.assertTrue( orgService.addOrg(org) );
      
      System.out.println("END Fast test");
    }
    
    @Test(groups = { "slow" })
    public void aSlowTest() {
       System.out.println("BEGIN Slow test");
       
       Assert.assertTrue( true );
       
       System.out.println("END Slow test");
    }
    */
}
