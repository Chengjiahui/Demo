package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Dept;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Inquery;
import com.example.demo.entity.User;



@Transactional
public interface IHospitalService {

	User login(String name, String pwd);

	List<Dept> deptList();

	List<Doctor> doctorList(String did);

	String getPrice(String dcid);

	int doRegistration(long inq_id, Inquery inquery, String did, String doc_id, String time, String date);

	List<Inquery> todayList();

	List<Inquery> findResult(String mohu);

	void addResult(String id, String result);

	String testName(String name);
          
}
