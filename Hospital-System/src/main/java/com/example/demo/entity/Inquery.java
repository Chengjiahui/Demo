package com.example.demo.entity;

public class Inquery {
	
	
     private  String inq_id ; 
     private  String inq_name ;
     private  String sex ;
     private  String phone ;
     private  Dept dept ;
     private  Doctor doctor ;
     private  int status ; 
     private  String  date ;
     private  String   time ;
     private  String  result ;
     
     
     

	public String getInq_id() {
		return inq_id;
	}
	public void setInq_id(String inq_id) {
		this.inq_id = inq_id;
	}
	public String getInq_name() {
		return inq_name;
	}
	public void setInq_name(String inq_name) {
		this.inq_name = inq_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
     
     
     

}
