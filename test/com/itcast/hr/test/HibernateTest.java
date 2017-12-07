package com.itcast.hr.test;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.itcast.hr.dao.IDepartmentDao;
import com.itcast.hr.entity.Department;
public class HibernateTest {
	@Resource
	private IDepartmentDao iDepartmentDao;
	@Test
	public void testHibernate(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
	}
	@Test
	public void testTree() {
		List<Department> list = iDepartmentDao.getAll();
		
	}
}
