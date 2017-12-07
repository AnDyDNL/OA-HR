package com.itcast.hr.test;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SprintTest {
	@Test
	public void springTest() {
/*		CerrorlassPathXmlApplicationContext context=new ClassPathXmlApplicationContext();
		System.out.println(context);
		*/
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ac);
		SessionFactory session = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println(session);
//		System.out.println(ac.getBean("roleAction"));
		/*Object bean = ac.getBean("sSTest");
		System.out.println("bean"+bean);
		Session session2 = session.getCurrentSession();
		System.out.println(session2);*/
	}
	@Test
	public void testTransaction(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ac.getBean("iDepartmentService");
	}
}
