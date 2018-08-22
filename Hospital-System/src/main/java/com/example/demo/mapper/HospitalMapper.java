package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Dept;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Inquery;
import com.example.demo.entity.User;

public interface HospitalMapper {
   @Select("select * from hosp_user where name =#{name} and pwd=#{pwd}")
	User login(@Param("name")String name,@Param("pwd")String pwd);
   @Select("select * from hosp_dept")
   List<Dept> deptList();
   @Select("select * from hosp_doctor where did =#{did}")
   List<Doctor> doctorList(@Param("did")String did);
   @Select("select price from hosp_doctor where doc_id=#{dcid}")
   String getPrice(@Param("dcid")String dcid);
   @Insert("insert into hosp_inquery values (#{inq_id},#{inquery.inq_name},#{inquery.sex},#{inquery.phone},#{did},#{doc_id},0,#{date},#{time},null)")
   int doRegistration(@Param("inq_id")long inq_id, @Param("inquery")Inquery inquery, @Param("did")String did, @Param("doc_id")String doc_id, @Param("time")String time, @Param("date")String date);
   List<Inquery> todayList();
   List<Inquery> findResult(@Param("mohu")String mohu);
   @Update("update hosp_inquery set result=#{result},status=1 where inq_id=#{id}")
   void addResult(@Param("id")String id,  @Param("result")String result);
   @Select("select name from hosp_user where name=#{name}")
   String testName(@Param("name")String name);

}
