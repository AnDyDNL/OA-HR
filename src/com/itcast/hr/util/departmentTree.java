package com.itcast.hr.util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.itcast.hr.entity.Department;
public class departmentTree {
	/**
	 * 遍历部门树，把所有的部门遍历出来修改名字，以层次显示
	 * @param topDepartmentList 所有的顶级部门（也就是所有的顶点）
	 * @return
	 */
	public static List<Department> getAllDepartment(List<Department> topDepartmentList) {
		//用于接收遍历否的部门集合
		List<Department> list=new ArrayList<Department>();
		//依次遍历每个顶点
		getDepartmentTree(topDepartmentList,"†",list);
		return list;
	}
	/**
	 * 遍历部门树
	 * @param departmentList
	 */
	public static List<Department> getDepartmentTree(Collection<Department> departmentList,String prefix,List<Department> list){
		//传入top部门
		for (Department department : departmentList) {
			//获取topDepartment的属性
			Department copy=new Department();
			copy.setName(prefix+department.getName());
			copy.setId(department.getId());
			//用于接收列表显示的部门
			list.add(copy);
			//递归显示子部门
			getDepartmentTree(department.getChildren(),"　"+prefix,list);
		}
		return list;
	}
}
