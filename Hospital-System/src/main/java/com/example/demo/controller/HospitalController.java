package com.example.demo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Dept;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Inquery;
import com.example.demo.entity.User;
import com.example.demo.service.IHospitalService;

@RestController
@RequestMapping("hospital")
public class HospitalController {
       @Autowired
       private IHospitalService  hospitalService ;
       
       @RequestMapping("login")
       public ModelAndView  login (HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
     	  Cookie[] cookies = request.getCookies();
     	  if(cookies!=null) {
 		  for (Cookie c : cookies) {
 			  if("chengjiahui".equals(c.getValue())){
 				   request.getRequestDispatcher("registration").forward(request, response);
 			  }			
 		}
 		  }
    	   return new ModelAndView("login");
       }
     	 
       @RequestMapping("testName")
       public boolean testName( String name) {
    	  System.out.println(name);
    	  String name1 =  hospitalService.testName(name);
    	  if(name1==null) return true ;
    	  else  return false ;
       }
      @RequestMapping(value="login", method=RequestMethod.POST) 
      public ModelAndView login(String x,String name,String pwd ,HttpSession session,HttpServletResponse response,HttpServletRequest request) throws IOException {
    	  User user = hospitalService.login(name,pwd);
            if(x==null&&user!=null) {   		
   		      session.setAttribute("user", user); 
   		      return new ModelAndView("registration");
    	  }if(x!=null&&user!=null) {
    	      Cookie  cookie = new Cookie("user","chengjiahui");
    		  cookie.setMaxAge(60*2);     
    		  response.addCookie(cookie);   		
    		  return new ModelAndView("registration");
    	  }
          request.getSession().setAttribute("mes", "账号,密码错误");
    	  return new ModelAndView("login");
      }
      
      @RequestMapping("registration")
      public ModelAndView registration() {
    	  return new ModelAndView("registration");
      }
      
      @RequestMapping("findDept")
      public List<Dept> findDept(){
		return  hospitalService.deptList();  	  
      }
      
      @RequestMapping("findDoctor")
      public List<Doctor> findDoctor(String did){  	  
    	  return hospitalService.doctorList(did);  	 
      }
      
      @RequestMapping("getPrice")
      public String  getPrice(String dcid) {
    	  return hospitalService.getPrice(dcid);
      }
      
      @RequestMapping("doRegistration")
      public boolean doRegistration(Inquery inquery,String did ,String doc_id) {
    	  SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    	  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	  // 获取  时分秒
    	  String time = format.format(new Date());  
    	  // 获取 年月日
    	  String date = df.format(new Date());  
    	  // 获取时间戳ID
    	  long inq_id = new Date().getTime();   
    	  return hospitalService.doRegistration(inq_id,inquery,did,doc_id,time,date)==1;
      }
      
      @RequestMapping("todayList")
      public ModelAndView todayList(Model model){
    	  List<Inquery> list = hospitalService.todayList();
    	  model.addAttribute("list", list);
    	  return new ModelAndView("todayList");
      }
      @RequestMapping("{name}doInquery{id}")
      public ModelAndView doInquery(@PathVariable String id ,@PathVariable String name,Model model) {
    	model.addAttribute("id", id);
    	model.addAttribute("name", name);
       return new ModelAndView("inquery");
		}
      
      @RequestMapping(value="addResult",method=RequestMethod.POST)
      public ModelAndView addResult(String result, String id) {
    	  hospitalService.addResult(id,result);
       return new ModelAndView("redirect:resultList");
		}
      
      @RequestMapping("resultList")
      public ModelAndView resultList(Model model,String mohu,HttpServletRequest request) {
    	  mohu= mohu==""?null:mohu ;
    	  if(mohu!=null)   request.setAttribute("mohu", mohu);
    	  else    request.setAttribute("mohu", "");
    	  List<Inquery> list =hospitalService.findResult(mohu);
    	  model.addAttribute("list", list);
    	  return new ModelAndView("resultList");
      }
}
