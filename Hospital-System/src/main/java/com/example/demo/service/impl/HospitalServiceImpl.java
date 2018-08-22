package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Dept;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Inquery;
import com.example.demo.entity.User;
import com.example.demo.mapper.HospitalMapper;
import com.example.demo.service.IHospitalService;
@Service
public class HospitalServiceImpl implements IHospitalService{
	@Autowired
	private HospitalMapper  hospitalMapper ;

	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		return hospitalMapper.login(name,pwd);
	}

	@Override
	public List<Dept> deptList() {
		// TODO Auto-generated method stub
		return hospitalMapper.deptList();
	}

	@Override
	public List<Doctor> doctorList(String did) {
		// TODO Auto-generated method stub
		return hospitalMapper.doctorList(did);
	}

	@Override
	public String getPrice(String dcid) {
		// TODO Auto-generated method stub
		return hospitalMapper.getPrice(dcid);
	}

	@Override
	public int doRegistration(long inq_id, Inquery inquery, String did, String doc_id, String time, String date) {
		// TODO Auto-generated method stub
		return hospitalMapper.doRegistration(inq_id,inquery,did,doc_id,time,date);
	}

	@Override
	public List<Inquery> todayList() {
		// TODO Auto-generated method stub
		return hospitalMapper.todayList();
	}

	@Override
	public List<Inquery> findResult(String mohu) {
		// TODO Auto-generated method stub
		return hospitalMapper.findResult(mohu);
	}

	@Override
	public void addResult(String id, String result) {
		// TODO Auto-generated method stub
		hospitalMapper.addResult(id,result);
	}

	@Override
	public String testName(String name) {
		// TODO Auto-generated method stub
		return hospitalMapper.testName(name);
	}

}
