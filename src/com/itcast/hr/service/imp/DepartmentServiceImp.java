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
@SuppressWarnings("unchecked")
public class DepartmentServiceImp implements IDepartmentService {
	// DepartmentDao dao // DepartmentDao extends DaoSupportImp<Department>
	@Resource
	private IDepartmentDao DepartmentDao;
	@Override
	public List<Department> getTop() {
		//当没有父级部门时为顶级部门
				return DepartmentDao.getTop();
	}
	@Override
	public List<Department> getChild(Long parentId) {
		return DepartmentDao.getChild(parentId);
	}
	@Override
	public List<Department> getAll() {
		return DepartmentDao.getAll();
	}
	@Override
	public void delete(Long id) {
		DepartmentDao.delete(id);		
	}
	@Override
	public void save(Department t) {
		DepartmentDao.save(t);
	}
	@Override
	public Department getById(Long id) {
		return DepartmentDao.getById(id);
	}
	@Override
	public void update(Department department) {
		DepartmentDao.update(department);
	}
}
