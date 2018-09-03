package com.teamsankya.studentapp.dto;

public class StudentInfoBean {
	private int regno;
	private String fname;
	private String mname;
	private String lname;
	
	public StudentInfoBean() {
		System.out.println("i am inside "+getClass().getSimpleName());
	}
	public int getRegno() {
		return regno;
	}
	public void setRegno(int regno) {
		this.regno = regno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	

}
