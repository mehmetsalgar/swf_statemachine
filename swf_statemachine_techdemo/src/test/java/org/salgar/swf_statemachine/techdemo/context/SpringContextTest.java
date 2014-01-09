package org.salgar.swf_statemachine.techdemo.context;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration(locations = {"/config/applicationContext.xml"})
public class SpringContextTest extends AbstractTestNGSpringContextTests {

	@Test
	public void initialize() {
		Assert.assertNotNull(this.applicationContext);
		
		Object obj = this.applicationContext.getBean("wordCountController");
		Assert.assertNotNull(obj);
	}
}
