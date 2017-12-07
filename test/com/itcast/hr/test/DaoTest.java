package com.itcast.hr.test;
import org.junit.Test;

import com.itcast.hr.dao.IRoleDao;
import com.itcast.hr.dao.imp.RoleDaoImp;
public class DaoTest {
	@Test
	public void daoTest(){
		IRoleDao role=new RoleDaoImp();
		Long o=null;
		Long id=(long) 5;
		long id2=4;
		id2=id;
//		long idd=null;
	}
}
