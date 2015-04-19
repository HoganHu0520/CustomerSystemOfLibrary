package com.hogan.model;

import com.hogan.model.base.BaseModel;

public class User extends BaseModel {
	private String name;
	private String password;
	
	public User(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Id -> " + this.id + "; Name -> " + this.name + "; Password -> " + this.password;
	}
}
