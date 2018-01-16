package com.itcast.hr.action;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.itcast.hr.baseaction.BaseAction;
import com.itcast.hr.entity.Role;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	private static final long serialVersionUID = 1L;
	//模型驱动
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
