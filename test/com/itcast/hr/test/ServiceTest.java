package com.itcast.hr.test;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itcast.hr.entity.Role;
@Service("serviceTest")
public class ServiceTest {
	@Resource
	private SessionFactory sessionFactory;
	@Transactional
	public void saveTwoUser() {
		Session session = sessionFactory.getCurrentSession();
		session.save(new Role());
//		int i=1/0;
		//抛异常
		session.save(new Role());
	}
}
