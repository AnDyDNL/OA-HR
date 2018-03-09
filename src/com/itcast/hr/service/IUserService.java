package com.itcast.hr.service;
import com.itcast.hr.basedao.DaoSupport;
import com.itcast.hr.entity.User;

public interface IUserService extends DaoSupport<User>{

	void setPassword(User user);

	Boolean findName(String name);

}
