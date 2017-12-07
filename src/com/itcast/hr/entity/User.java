package com.itcast.hr.entity;
import java.util.Set;
public final class User {
	private long id;
	private String name;//真实姓名
	private String loginName;//登录名
	private String password;
	private String description;
	private String gender;
	private String email;
	private String tel;
	private Department department;//一名用户对应一个部门
	private Set<Role> roles;//一名用户对应多个岗位
	public User(long id, String name, String loginName, String password,
			String description, String gender, String email, String tel,
			Department department, Set<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.description = description;
		this.gender = gender;
		this.email = email;
		this.tel = tel;
		this.department = department;
		this.roles = roles;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emaiil) {
		this.email = emaiil;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
