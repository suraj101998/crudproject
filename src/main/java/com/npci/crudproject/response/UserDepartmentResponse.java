package com.npci.crudproject.response;

import lombok.Data;

@Data
public class UserDepartmentResponse {

	private String USER_NAME;
	private String departmentName;
	
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}