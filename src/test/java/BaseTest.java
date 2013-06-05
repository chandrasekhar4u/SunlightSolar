/**
 * 
 */
package test.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CHANDRA
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	    locations = {"classpath:/WEB-INF/applicationContextTest.xml", "classpath:/WEB-INF/context.xml"}) 
@TransactionConfiguration
@Transactional
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Test
    public void dummyTest(){
	
    }
    
    
}
