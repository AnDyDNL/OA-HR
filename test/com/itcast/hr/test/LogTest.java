package com.itcast.hr.test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogTest {
	private ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	private Log log=LogFactory.getLog(this.getClass());
	@Test
	public void testLog(){
		log.debug("degug");
		log.warn("这是错误信息");
	}
}
