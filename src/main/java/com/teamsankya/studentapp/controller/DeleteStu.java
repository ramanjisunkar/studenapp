package com.teamsankya.studentapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.teamsankya.studentapp.dao.StudentDao;
import com.teamsankya.studentapp.util.StudentService;

@WebServlet("/delete")
public class DeleteStu extends HttpServlet{
	Logger LOGGER=Logger.getLogger(DeleteStu.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOGGER.info("inside deletestu.. doget() started..");
		int reg=Integer.parseInt(req.getParameter("regno"));
		StudentDao dao = (StudentDao) StudentService.getInstence().daoCreater();
		int res=dao.delete(reg);
		if(res==1) {
			RequestDispatcher dis= req.getRequestDispatcher("success.jsp");
			dis.forward(req, resp);
		}
		else {
			
		}
		
		
		
	}

}
