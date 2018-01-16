package com.itcast.hr.service;
import java.util.List;

import com.itcast.hr.entity.Department;
public interface IDepartmentService {

	List<Department> getAll();

	void delete(Long id);

	void save(Department model);

	Department getById(Long id);

	void update(Department department);

	/**
	 * 获取顶级部门
	 * @return
	 */
	List<Department> getTop();
	/**
	 * 获取子节点
	 * @param parentId 
	 * @return
	 */
	List<Department> getChild(Long parentId);
}
