package com.cts.grizzlywebstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Login {

	@Id
    @Column
	private String userName;
    
    @Column
	private String password;
	
	
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + "]";
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Login(String userName, String password) {
		
		super();
		this.userName = userName;
		this.password = password;
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
