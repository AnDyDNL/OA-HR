package com.itcast.hr.action;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.itcast.hr.baseaction.BaseAction;
import com.itcast.hr.entity.Department;
import com.itcast.hr.util.MyUtil;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 上级部门id
	private Long parentId;
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 列表界面
	 * 
	 * @return
	 */
	public String list() {
		List<Department> departmentList = null;
		if (parentId == null) {
			// 查询所有top
			departmentList = iDepartmentService.getTop();
		} else {
			// 查询所有子部门
			departmentList = iDepartmentService.getChild(parentId);
		}
		// 得到集合后放入值栈（map #获取）
		ActionContext.getContext().put("departmentList", departmentList);
		return "list";
	}

	/**
	 * 添加岗位页面
	 * 
	 * @return
	 */
	public String addUI() {
		// 准备数据 上级部门列表
		List<Department> topDepartmentList = iDepartmentService.getTop();
		// id name 传入到部门的下拉列表，只给这两个属性赋值
		List<Department> departmentList = MyUtil
				.getAllDepartment(topDepartmentList);
		// 得到集合后放入值栈（map #获取）
		ActionContext.getContext().put("departmentList", departmentList);
		return "saveUI";
	}

	/**
	 * 确认添加岗位
	 * 
	 * @return
	 */
	public String add() {
		// 保存到对象
		// Role role=new Role();
		// role.setName(name);
		// role.setDescription(description);
		// 保存到数据库
		model.setParent(iDepartmentService.getById(parentId));
		iDepartmentService.save(model);
		return "toList";
	}

	/**
	 * 删除岗位
	 * 
	 * @return
	 */
	public String delete() {
		System.out.println("*** delete...");
		iDepartmentService.delete(model.getId());
		return "toList";
	}

	/**
	 * 修改岗位页面
	 * 
	 * @return
	 */
	public String editUI() {
		// 准备数据 上级部门列表
		List<Department> topDepartmentList = iDepartmentService.getTop();
		// id name 传入到部门的下拉列表，只给这两个属性赋值
		List<Department> departmentList = MyUtil.getAllDepartment(topDepartmentList);
		// 得到集合后放入值栈（map #获取）
		ActionContext.getContext().put("departmentList", departmentList);
		Department department = iDepartmentService.getById(model.getId());
		//department放入值栈用于回显
		ActionContext.getContext().getValueStack().push(department);
		// 获取上级部门
		Department parent = department.getParent();
		if (parent != null) {
			// 相对应的属性有值就能回显
			parentId = parent.getId();
		}
		return "saveUI";
	}

	/**
	 * 确定修改
	 * 
	 * @return
	 */
	public String edit() {
		// 从数据库去除原对象
		Department department = iDepartmentService.getById(model.getId());
		department.setName(model.getName());
		department.setDescription(model.getDescription());
		// 获取parent
		Department parent = iDepartmentService.getById(parentId);
		department.setParent(parent);
		iDepartmentService.update(department);
		return "toList";
	}
}
