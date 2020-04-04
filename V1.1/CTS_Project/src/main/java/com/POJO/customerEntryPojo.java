package com.POJO;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity(name =customerEntryPojo.PERSISTANCE_NAME)
@Table(name = customerEntryPojo.PERSISTANCE_NAME )
public class customerEntryPojo {
	static final String PERSISTANCE_NAME = "Customer";

	int customer_ID;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_ID", updatable = false, nullable = false)
	
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	
	
	String customer_Name;
	String customer_Phone;
	String customer_Password;
	String customer_Address;
	
	
	
	@Column(name="customer_Name")
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	@Column(name="customer_Phone")
	public String getCustomer_Phone() {
		return customer_Phone;
	}
	public void setCustomer_Phone(String customer_Phone) {
		this.customer_Phone = customer_Phone;
	}
	@Column(name="customer_Password")
	public String getCustomer_Password() {
		return customer_Password;
	}
	public void setCustomer_Password(String customer_Password) {
		this.customer_Password = customer_Password;
	}
	@Column(name="customer_Address")
	public String getCustomer_Address() {
		return customer_Address;
	}
	public void setCustomer_Address(String customer_Address) {
		this.customer_Address = customer_Address;
	}
	
	private int flag;

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	

}
