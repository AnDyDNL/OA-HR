package com.itcast.hr.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.itcast.hr.entity.Role;

public interface IRoleService {
	//列表
	List<Role> getAll();
	//删除
	void delete(Long id);
	//保存
	void save(Role role);
	//查询
	Role getById(Long id);
	
	void update(Role role);

}
