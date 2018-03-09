package com.itcast.hr.action;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itcast.hr.baseaction.BaseAction;
import com.itcast.hr.entity.Department;
import com.itcast.hr.entity.Role;
import com.itcast.hr.entity.User;
import com.itcast.hr.util.departmentTree;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		/**
		  * 用户列表界面
		  * @return
		  */
		public String list(){
			 List<User> userList = iUserService.getAll();
			 ActionContext.getContext().put("userList", userList);
			 return "list";
		 }
		 /**
		  * 添加用户页面
		  * @return
		  */
		public String addUI(){
			//显示部门列表
			// 准备数据 上级部门列表
			List<Department> topDepartmentList = iDepartmentService.getTop();
			// id name 传入到部门的下拉列表，只给这两个属性赋值
			List<Department> departmentList = departmentTree
					.getAllDepartment(topDepartmentList);
			//显示岗位列表
			List<Role> roleList = iRoleService.getAll();
			//放入值栈
			ActionContext.getContext().put("departmentList", departmentList);
			ActionContext.getContext().put("roleList", roleList);
			return "saveUI";
		 }
		 /**
		  * 确认添加用户
		  * @return
		  */
		public String  add(){
			//封装部门传过来的是id
			model.setDepartment(iDepartmentService.getById(departmentId));
			//接收传过来的role
			List<Role> roles = iRoleService.getByIds(roleIds);
			model.setRoles(new HashSet<Role>(roles));
			//保存到数据库
			iUserService.save(model);
			return "toList";
		 }
		 /**
		  * 删除岗位	
		  * @return
		  */
		public String  delete(){
			iUserService.delete(model.getId());
			 return "toList";
		 }
		 /**
		  * 修改岗位页面
		  * @return
		  */
		public String  editUI(){
			// 显示部门列表先准备数据 上级部门列表
			List<Department> topDepartmentList = iDepartmentService.getTop();
			// id name 传入到部门的下拉列表，只给这两个属性赋值
			List<Department> departmentList = departmentTree
					.getAllDepartment(topDepartmentList);
			//显示岗位列表
			List<Role> roleList = iRoleService.getAll();
			//放入值栈
			ActionContext.getContext().put("departmentList", departmentList);
			ActionContext.getContext().put("roleList", roleList);
			User user=iUserService.getById(model.getId());
			//放入栈顶用于回显
			ActionContext.getContext().getValueStack().push(user);
			//获取部门id
			if(user.getDepartment()!=null){	
				departmentId=user.getDepartment().getId();
			}
			//获取岗位ids
			if(user.getRoles()!=null){	
				int index=0;
				roleIds=new Long[user.getRoles().size()];
				for (Role role : user.getRoles()) {
					roleIds[index++]=role.getId();
				}
			}
			return "saveUI";
		 }
		 /**
		  * 确定修改
		  * @return
		  */
		public String  edit(){
			iUserService.update(model);
			return "toList";
		 }
		/**
		 * 查询用户
		 */
		public String getById(){
			//从数据库获取原来的对象
			User user = iUserService.getById(model.getId());
			//设置更改后的数据
			user.setDepartment(iDepartmentService.getById(departmentId));
			user.setDescription(model.getDescription());
			user.setEmail(model.getEmail());
			user.setGender(model.getGender());
			user.setLoginName(model.getLoginName());
			user.setName(model.getName());
			user.setPassword(model.getPassword());
			user.setTel(model.getTel());
			List<Role> roles = iRoleService.getByIds(roleIds);
			user.setRoles(new HashSet<Role>(roles));
			//保存到数据库
			iUserService.update(user);
			return "toList";
		}
		/**
		 * @author ding 
		 * 
		 * 初始化密码
		 */
		public String setUserPassword(){
			//从数据库查找对象
			User user = iUserService.getById(model.getId());
			user.setPassword("1234");
			//更改后的数据保存到数据库
			iUserService.setPassword(user);
			return "toList";
			
		}
		/**
		 * @author ding 
		 * 
		 * 确保用户名唯一
		 */
		public String validateName(){
			//接收用户名
			String name=model.getName();
			System.out.println(name);
			//从数据库查找用户名
			Boolean flag = iUserService.findName(name);
			if(flag){
				//存在用户
			}
			ActionContext.getContext();
			return "toList";
			
		}
		//-----------没有传过来的属性额外添加getset方法-------------
		private Long departmentId;
		private Long [] roleIds;
		public Long[] getRoleIds() {
			return roleIds;
		}
		public void setRoleIds(Long[] roleIds) {
			this.roleIds = roleIds;
		}
		public Long getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}
		private String password;
		public String getPassword(){
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
}
