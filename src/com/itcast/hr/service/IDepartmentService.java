package com.itcast.hr.service;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.itcast.hr.entity.Department;
public interface IDepartmentService {
	/**
	 * 部门列表
	 * @return
	 */
	List<Department> getAll();
	/**
	 * 更新部门
	 * @return
	 */
	void update(Department model);
	/**
	 * 根据id查询部门
	 * @return
	 */
	Department getById(Long id);
	/**
	 * 根据id删除部门
	 * @return
	 */
	void delete(long id);
	/**
	 * 增加部门
	 * @return
	 */
	void save(Department model);
	/**
	 * 显示top部门（也就是最上级部门）
	 * 
	 */
	List<Department> getTop();
	/**
	 * 获取子节点
	 * @param parentId 
	 * @return
	 */
	List<Department> getChild(Long parentId);

}
