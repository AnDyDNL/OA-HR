package com.itcast.hr.baseaction;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.itcast.hr.service.IDepartmentService;
import com.itcast.hr.service.IRoleService;
import com.itcast.hr.service.IUserService;
import com.itcast.hr.service.imp.UserServiceImp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//提供ModelDriver支持提供Service
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
//==============模型驱动================
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Class<T> clazz;
	protected T model;
	@SuppressWarnings("unchecked")
	public BaseAction(){
		ParameterizedType pt=(ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz=(Class<T>) pt.getActualTypeArguments()[0];//获取子类的真是类型
		try {
			 model = clazz.newInstance();  
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
//===============service====================
	@Resource
	protected IRoleService iRoleService;
	@Resource
	protected IDepartmentService iDepartmentService; 
	@Resource
	protected IUserService iUserService; 
}
