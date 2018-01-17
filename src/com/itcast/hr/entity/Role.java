package com.itcast.hr.entity;
import java.util.Set;
public class Role {
	private long id;
	private String name;
	private String description;
	private Set<User> users; //一个岗位对应多名员工
	private Set<Privilege> prvilefge;//对应多个角色
	//-----------构造函数--------------
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(long id, String name, String description, Set<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.users = users;
	}
	//----------get set-------------
	public void setPrvilefge(Set<Privilege> prvilefge) {
		this.prvilefge = prvilefge;
	}
	public Set<Privilege> getPrvilefge() {
		return prvilefge;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
