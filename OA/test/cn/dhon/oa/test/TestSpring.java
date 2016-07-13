package cn.dhon.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	private ApplicationContext ac  = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testSessionFactory(){
		SessionFactory sf = (SessionFactory)ac.getBean("sessionFactory");
		System.out.println(sf.openSession());
	}
	
	@Test
	public void testTx(){
		TestService ts = (TestService)ac.getBean("testService");
		ts.saveTwoUsers();
	}

}
