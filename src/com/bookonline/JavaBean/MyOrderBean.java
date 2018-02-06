package com.bookonline.JavaBean;

public class MyOrderBean {
	private String ordered;
	private int price;
	private String tel;
	private String username;
	private String fname;
	public MyOrderBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyOrderBean(String ordered, int price, String tel, String username, String fname) {
		super();
		this.ordered = ordered;
		this.price = price;
		this.tel = tel;
		this.username = username;
		this.fname = fname;
	}
	public String getOrdered() {
		return ordered;
	}
	public void setOrdered(String ordered) {
		this.ordered = ordered;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "MyOrderBean [ordered=" + ordered + ", price=" + price + ", tel=" + tel + ", username=" + username
				+ ", fname=" + fname + "]";
	}
	
	
}
