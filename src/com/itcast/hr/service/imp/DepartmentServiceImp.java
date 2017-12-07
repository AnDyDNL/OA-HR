package com.itcast.hr.service.imp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itcast.hr.dao.IDepartmentDao;
import com.itcast.hr.entity.Department;
import com.itcast.hr.service.IDepartmentService;
@Service("iDepartmentService")
@Transactional // 开启事务
public class DepartmentServiceImp implements IDepartmentService {
	@Resource //ioc容器中获取dao接口
	private IDepartmentDao iDepartmentDao;
	@Override
	public List<Department> getAll() {
		//返回部门列表
		return iDepartmentDao.getAll();
	}
	@Override
	public void update(Department model) {
		iDepartmentDao.update(model);
	}
	@Override
	public Department getById(Long id) {
			return iDepartmentDao.getById(id);
	}
	@Override
	public void delete(long id) {
		iDepartmentDao.delete(id);
	}
	@Override
	public void save(Department model) {
		iDepartmentDao.save(model);
	}
	@Override
	public List<Department> getTop() {
		return iDepartmentDao.getTop();
	}
	@Override
	public List<Department> getChild(Long parentId) {
		return iDepartmentDao.getChild(parentId);
	}
}
