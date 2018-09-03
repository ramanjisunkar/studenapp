package com.teamsankya.studentapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.teamsankya.studentapp.dto.StudentInfoBean;
import com.teamsankya.studentapp.dto.StudentMasterBean;

public interface StudentDao {
	public int createStu(StudentMasterBean bean) throws SQLException;
	public void editStu(int rengo);
	public int updateStu(int regno,StudentMasterBean bean);
	public StudentMasterBean getall(int regno);
	public int delete(int regno);

}
