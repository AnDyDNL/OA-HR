package com.itcast.hr.action;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.itcast.hr.entity.Role;
import com.itcast.hr.service.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport implements ModelDriven<Role>{
	private static final long serialVersionUID = 1L;
	//容器中得到service
	@Resource
	private IRoleService roleService;
	private Role model=new Role();
	//模型驱动
	@Override
	public Role getModel() {
		// TODO Auto-generated method stub
		return model;
	}

//	private Long id;//role的id
//	private String  name;//role的name
//	private String  description;//role的description
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	/**
	  * 列表界面
	  * @return
	  */
	public String  list(){
		List<Role> roleList =roleService.getAll();
		//得到集合后放入值栈
		ActionContext.getContext().put("roleList", roleList);
		 return "list";
	 }
	 /**
	  * 添加岗位页面
	  * @return
	  */
	public String  addUI(){
		 return "saveUI";
	 }
	 /**
	  * 确认添加岗位
	  * @return
	  */
	public String  add(){
		//保存到对象
//		Role role=new Role();
//		role.setName(name);
//		role.setDescription(description);
		//保存到数据库
		roleService.save(model);
		return "toList";
	 }
	 /**
	  * 删除岗位	
	  * @return
	  */
	public String  delete(){
		roleService.delete(model.getId());
		 return "toList";
	 }
	 /**
	  * 修改岗位页面
	  * @return
	  */
	public String  editUI(){
	
		Role role=roleService.getById(model.getId());
		//放入值栈用于回显
		ActionContext.getContext().getValueStack().push(role);
		return "saveUI";
	 }
	 /**
	  * 确定修改
	  * @return
	  */
	public String  edit(){
		roleService.update(model);
		return "toList";
	 }

	
}
