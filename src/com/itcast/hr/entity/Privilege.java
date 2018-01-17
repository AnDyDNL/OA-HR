package com.itcast.hr.entity;
import java.util.Set;
public class Privilege {
	//权限名字、权限对应的路径、主键id、对应的角色set、上级权限、下级权限
	private String name;
	private String URL;
	private Long id;
	private Set<Role> role; 
	private Privilege parent;
	private Set<Privilege> children;
	public Privilege() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}
	public Set<Privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<Privilege> children) {
		this.children = children;
	}
	
}
