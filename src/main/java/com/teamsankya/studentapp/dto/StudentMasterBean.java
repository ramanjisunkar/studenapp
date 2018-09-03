package com.teamsankya.studentapp.dto;

public class StudentMasterBean {
private StudentInfoBean info;
private StudentAddressBean addr;
private GuardianInfoBean  auar;
public StudentInfoBean getInfo() {
	return info;
}
public void setInfo(StudentInfoBean info) {
	this.info = info;
}
public StudentAddressBean getAddr() {
	return addr;
}
public void setAddr(StudentAddressBean addr) {
	this.addr = addr;
}
public GuardianInfoBean getAuar() {
	return auar;
}
public void setAuar(GuardianInfoBean auar) {
	this.auar = auar;
}

	
}
