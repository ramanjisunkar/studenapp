package com.teamsankya.studentapp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamsankya.studentapp.dao.StudentDao;
import com.teamsankya.studentapp.util.StudentService;
@WebServlet("/editstu")
public class EditStu extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int regno=Integer.parseInt(req.getParameter("regno"));
		StudentDao dao = (StudentDao) StudentService.getInstence().daoCreater();
		dao.editStu(regno);
		RequestDispatcher dis= req.getRequestDispatcher("EditStu.jsp");
		dis.forward(req, resp);
		
	}

}
