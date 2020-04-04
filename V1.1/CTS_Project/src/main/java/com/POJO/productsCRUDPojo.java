package com.POJO;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;




@Entity
@Table(name = "Products")
public class productsCRUDPojo {
	
	
	
	 public productsCRUDPojo() {
		
	}	
	public productsCRUDPojo(int product_ID, String product_Name, String product_Cost, String product_Picture) {
		super();
		this.product_ID = product_ID;
		this.product_Name = product_Name;
		this.product_Cost = product_Cost;
		this.product_Picture = product_Picture;	}
	@Id
	@Column(name = "product_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int product_ID;
	
	@Column(name = "product_Name")
	String product_Name;
	@Column(name="product_Cost")
	String product_Cost;
	@Column(name="product_Picture")
	String product_Picture;
	
	
	public int getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Cost() {
		return product_Cost;
	}
	public void setProduct_Cost(String product_Cost) {
		this.product_Cost = product_Cost;
	}
	public String getProduct_Picture() {
		return product_Picture;
	}
	public void setProduct_Picture(String product_Picture) {
		this.product_Picture = product_Picture;
	}
	

}
