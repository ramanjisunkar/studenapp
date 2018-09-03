package com.teamsankya.studentapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.teamsankya.studentapp.dao.StudentDao;
import com.teamsankya.studentapp.dto.GuardianInfoBean;
import com.teamsankya.studentapp.dto.StudentAddressBean;
import com.teamsankya.studentapp.dto.StudentInfoBean;
import com.teamsankya.studentapp.dto.StudentMasterBean;
import com.teamsankya.studentapp.util.StudentService;
@WebServlet("/createprofile")
public class CreateStudent extends HttpServlet {
	Logger LOGGER=Logger.getLogger(CreateStudent.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("inside"+getClass().getSimpleName());
		StudentInfoBean info=new StudentInfoBean();
		
		info.setRegno(Integer.parseInt(req.getParameter("regno")));
		LOGGER.info("collecting data from view and setting data to StudentInfoBean");
		info.setFname(req.getParameter("fnm"));
		info.setMname(req.getParameter("mnm"));
		info.setLname(req.getParameter("lnm"));
		
		StudentAddressBean add=new StudentAddressBean();
		LOGGER.info("collecting data from view and setting data to StudentAddressBean ");
		add.setAddr1(req.getParameter("pre.addr1"));
		add.setAddr2(req.getParameter("pre.addr2"));
		add.setAddr_Type(req.getParameter("presentaddr"));
		add.setCity(req.getParameter("pre.city"));
		add.setPincode(Integer.parseInt(req.getParameter("pre.pincode")));
		add.setRegno(Integer.parseInt(req.getParameter("regno")));
		
		GuardianInfoBean gbean=new GuardianInfoBean();
		LOGGER.info("collecting data from view and  setting data to GuardianInfoBean..");
		gbean.setGfname(req.getParameter("gfnm"));
		gbean.setGmname(req.getParameter("gmnm"));
		gbean.setGlname(req.getParameter("glnm"));
		gbean.setRengo(Integer.parseInt(req.getParameter("regno")));
		
		StudentMasterBean mbean=new StudentMasterBean();
		LOGGER.info("setting all beans to masterbean");
		mbean.setAddr(add);
		mbean.setAuar(gbean);
		mbean.setInfo(info);
		
		LOGGER.info("collected and setting part is over..");
		LOGGER.info("calling daoCreater()..");
		StudentDao dao = (StudentDao) StudentService.getInstence().daoCreater();
		try {
			int a=dao.createStu(mbean);
			if(a==1)
			{
				RequestDispatcher dis=req.getRequestDispatcher("index.jsp");
				dis.include(req, resp);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
