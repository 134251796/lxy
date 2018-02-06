package com.bookonline.JavaBean;

public class TicketBean {
	private String fname;
	private String fdirector;
	private String fmactor;
	private String time;
	private String price;	
	private String shengyu;
	
	
	public TicketBean() {
		super();
	}


	public TicketBean(String fname, String fdirector, String fmactor, String time, String price, String shengyu) {
		super();
		this.fname = fname;
		this.fdirector = fdirector;
		this.fmactor = fmactor;
		this.time = time;
		this.price = price;
		this.shengyu = shengyu;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getFdirector() {
		return fdirector;
	}


	public void setFdirector(String fdirector) {
		this.fdirector = fdirector;
	}


	public String getFmactor() {
		return fmactor;
	}


	public void setFmactor(String fmactor) {
		this.fmactor = fmactor;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getShengyu() {
		return shengyu;
	}


	public void setShengyu(String shengyu) {
		this.shengyu = shengyu;
	}


	@Override
	public String toString() {
		return "TicketBean [fname=" + fname + ", fdirector=" + fdirector + ", fmactor=" + fmactor + ", time=" + time
				+ ", price=" + price + ", shengyu=" + shengyu + "]";
	}
	
	
	
}
