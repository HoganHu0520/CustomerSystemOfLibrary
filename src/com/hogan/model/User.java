package com.hogan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hogan.model.base.BaseModel;

@Entity
@Table(name = "t_user")
public class User extends BaseModel {
	private String name;
	private String password;
	private String userId;
	
	public User(){}
	
	@Override
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return super.id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 16)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "user_id", length = 45)
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Id -> " + this.id + "; Name -> " + this.name + "; Password -> " + this.password + "; UserId -> " + this.userId;
	}
}

