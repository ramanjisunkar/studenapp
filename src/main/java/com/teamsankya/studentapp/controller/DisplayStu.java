package com.teamsankya.studentapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.teamsankya.studentapp.dao.StudentDao;
import com.teamsankya.studentapp.dto.StudentInfoBean;
import com.teamsankya.studentapp.dto.StudentMasterBean;
import com.teamsankya.studentapp.util.StudentService;

@WebServlet("/display")
public class DisplayStu extends HttpServlet{
	Logger LOGGER=Logger.getLogger(DisplayStu.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("inside doGet() of DisplayStu class..  ");
		int regno=Integer.parseInt(req.getParameter("regno"));
		LOGGER.info("calling daocreater()... ");
		StudentDao dao = (StudentDao) StudentService.getInstence().daoCreater();
		LOGGER.info("daocreater()  obj created..");
		try {
			LOGGER.info("calling getall()..which returns bean..");
			StudentMasterBean m=dao.getall(regno); 
			LOGGER.info("setting bean data to session attributes ");
			 HttpSession s=req.getSession(true);
			 s.setAttribute("regno", m.getInfo().getRegno());
			 s.setAttribute("fname", m.getInfo().getFname());
			 s.setAttribute("mname",m.getInfo().getMname());
			 s.setAttribute("lname",m.getInfo().getLname());
			 
			 s.setAttribute("gfname",m.getAuar().getGfname());
			 s.setAttribute("gmname",m.getAuar().getGmname());
			 s.setAttribute("glname",m.getAuar().getGlname());
			 
			 s.setAttribute("addtype",m.getAddr().getAddr_Type());
			 s.setAttribute("add1",m.getAddr().getAddr1());
			 s.setAttribute("add2",m.getAddr().getAddr2());
			 s.setAttribute("city",m.getAddr().getCity());
			 s.setAttribute("pincode",m.getAddr().getPincode());
			 
			 LOGGER.info("setting session attributes complited..  ");
			 RequestDispatcher dis=req.getRequestDispatcher("Studentviewall.jsp");
			 dis.forward(req, resp);
				
			  
		}catch (Exception e)
					{
						e.printStackTrace();
				}
	
	}
	}
	

