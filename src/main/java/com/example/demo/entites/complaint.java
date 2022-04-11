package com.example.demo.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column
	private String name;
	@Column
	private String emailid;
	@Column
	private String mobileno;
	private int ordid;
	private String msg;

	public complaint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public complaint(long id, String name, String emailid, String mobileno, int ordid) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.mobileno = mobileno;
		this.ordid = ordid;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public int getOrdid() {
		return ordid;
	}

	public void setOrdid(int ordid) {
		this.ordid = ordid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
