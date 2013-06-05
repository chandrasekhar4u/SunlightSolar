/**
 * 
 */
package test.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author CHANDRA
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:WEB-INF/applicationContextTest.xml",
	"classpath:WEB-INF/context.xml" })
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {
    
    @Test
    public void dummyTest(){
	
    }

}
