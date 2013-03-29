/**
 * 
 */
package test.java;

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
	"classpath:META-INF/conf/spring/applicationContextTest.xml",
	"classpath:META-INF/conf/spring/context.xml" })
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

}
