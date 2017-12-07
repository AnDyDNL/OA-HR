package com.itcast.hr.dao.imp;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import com.itcast.hr.basedao.imp.BaseDaoImp;
import com.itcast.hr.dao.IDepartmentDao;
import com.itcast.hr.entity.Department;
@Controller("iDepartmentDao")
@SuppressWarnings("unchecked")
public class DepartmentDaoImp extends BaseDaoImp<Department> implements IDepartmentDao{
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 查询顶级部门
	 * @return
	 */
	@Override
	public List<Department> getTop() {
		//当没有父级部门时为顶级部门
		List<Department> list = getSession().createQuery
				("FROM Department where parentId is null")
				.list();
		return list;
	}
	/**
	 * 查询子部门
	 * @return
	 */
	@Override
	public List<Department> getChild(Long parentId) {
		List<Department> list = getSession().createQuery
				("FROM Department where parentId=?")
				.setParameter(0, parentId)
				.list();
		return list;
	}

}
