package com.teamsankya.studentapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamsankya.studentapp.dao.StudentDao;
import com.teamsankya.studentapp.dto.GuardianInfoBean;
import com.teamsankya.studentapp.dto.StudentAddressBean;
import com.teamsankya.studentapp.dto.StudentInfoBean;
import com.teamsankya.studentapp.dto.StudentMasterBean;
import com.teamsankya.studentapp.util.StudentService;
@WebServlet("/updatestu")
public class UpdateStu extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int regno=Integer.parseInt(req.getParameter("regno"));
		StudentInfoBean info=new StudentInfoBean();
		info.setRegno(Integer.parseInt(req.getParameter("regno")));
		info.setFname(req.getParameter("fnm"));
		info.setMname(req.getParameter("mnm"));
		info.setLname(req.getParameter("lnm"));
		GuardianInfoBean gbean=new GuardianInfoBean();
		gbean.setGfname(req.getParameter("gfnm"));
		gbean.setGmname(req.getParameter("gmnm"));
		gbean.setGlname(req.getParameter("glnm"));
		gbean.setRengo(Integer.parseInt(req.getParameter("regno")));
		StudentAddressBean addr=new StudentAddressBean();
		addr.setAddr_Type(req.getParameter("presentaddr"));
		addr.setAddr1(req.getParameter("pre.addr1"));
		addr.setAddr2(req.getParameter("pre.addr2"));
		addr.setCity(req.getParameter("pre.city"));
		addr.setRegno(Integer.parseInt(req.getParameter("regno")));
		addr.setPincode(Integer.parseInt(req.getParameter("pre.pincode")));
		
		StudentMasterBean mbean=new StudentMasterBean();
		mbean.setAuar(gbean);
		mbean.setInfo(info);
		mbean.setAddr(addr);
		StudentDao dao = (StudentDao) StudentService.getInstence().daoCreater();
		int a=dao.updateStu(regno,mbean);
		if(a==1)
		{
			RequestDispatcher dis=req.getRequestDispatcher("success.jsp");
			dis.forward(req, resp);
		}
		
		
	}
		
		
	

}
