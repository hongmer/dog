package edu.hunnu.model;

import java.io.Serializable;
public class roles implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer rolesId;
    private String rolesName;
	public Integer getRolesId() {
		return rolesId;
	}
	public void setRolesId(Integer rolesId) {
		this.rolesId = rolesId;
	}
	public String getRolesName() {
		return rolesName;
	}
	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}
	@Override
	public String toString() {
		return "roles [rolesId=" + rolesId + ", rolesName=" + rolesName + "]";
	}
    
  
}