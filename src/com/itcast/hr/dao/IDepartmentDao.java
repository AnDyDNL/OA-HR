package com.itcast.hr.dao;
import java.util.List;

import com.itcast.hr.basedao.IBaseDao;
import com.itcast.hr.entity.Department;

public interface IDepartmentDao extends IBaseDao<Department> {
	/**
	 * 查询顶级部门
	 * @return
	 */
	List<Department> getTop();
	/**
	 * 查询子部门
	 * @return
	 */
	List<Department> getChild(Long patentId);

}
