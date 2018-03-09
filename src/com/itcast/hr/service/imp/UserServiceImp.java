package com.itcast.hr.service.imp;


import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.itcast.hr.basedao.imp.DaoSupportImp;
import com.itcast.hr.entity.User;
import com.itcast.hr.service.IUserService;
@Service("iUserservice")
public class UserServiceImp extends DaoSupportImp<User> implements IUserService{

	@Override
	public void setPassword(User user) {
		getSession().update(user);
	}
	@Override
	public Boolean findName(String name) {
		// TODO Auto-generated method stub
		//面向对象的查询与数据库无关
		Query query = getSession().createQuery("select u.name FROM User u where name=?");
		query.setString(0,name);
		if(null==query.list()){
			return false;
		}
		else{
			return true;
		}
	}
}
