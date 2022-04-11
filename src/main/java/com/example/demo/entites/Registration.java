package com.example.demo.entites;
//import javax.validation.constraints.NotNull;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int regid;
	String name;
	String email;
	String password;
	String contact;
	String usertype;	
	@OneToMany(mappedBy="customer",
            orphanRemoval = true)
    private List<CakeInfo> cakes;
	
	
	

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration( String name, String email, String password, String contact, String usertype) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.usertype = usertype;
	}
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public List<CakeInfo> getCakes() {
		return cakes;
	}
	public void setCakes(List<CakeInfo> cakes) {
		this.cakes = cakes;
	}
	
	 public void addCake(CakeInfo cake) {
	        cakes.add(cake);
	        cake.setCustomer(this);
	    }

	    public void removeCake(CakeInfo cake) {
	        cakes.remove(cake);
	        cake.setCustomer(null);
	    }
	

}
