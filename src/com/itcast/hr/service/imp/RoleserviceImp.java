package com.itcast.hr.service.imp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itcast.hr.dao.IRoleDao;
import com.itcast.hr.entity.Role;
import com.itcast.hr.service.IRoleService;
@Service("roleService")
@Transactional // 开启事务
public class RoleserviceImp implements IRoleService {
	@Resource //ioc容器中获取
	private IRoleDao roleDao;
	@Override

	public List<Role> getAll() {
		//公共方法中的getAll
		return  roleDao.getAll();
	}
	@Override
	public void delete(Long id) {
		//调用dao层
		roleDao.delete(id);
	}
	@Override
	public void save(Role role) {
		roleDao.save(role);
	}
	@Override
	public Role getById(Long id) {
		return roleDao.getById(id);
		
	}
	@Override
	public void update(Role role) {
		roleDao.update(role);
		
	}


}
