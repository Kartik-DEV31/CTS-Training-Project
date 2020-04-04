package com.POJO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class adminLoginPojo {
	int admin_ID;
	String email_ID;
	String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_ID", updatable = false, nullable = false)
	public int getAdmin_ID() {
		return admin_ID;
	}
	
	@Column(name = "email_ID")
		public String getEmail_ID() {
		return email_ID;
	}
	
	@Column(name = "password")
		public String getPassword() {
		return password;
	}

	public void setAdmin_ID(int admin_ID) {
		this.admin_ID = admin_ID;
	}

	public void setEmail_ID(String email_ID) {
		this.email_ID = email_ID;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private int flag;

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	

}
