package com.teamsankya.studentapp.util;

import java.io.FileReader;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.teamsankya.studentapp.controller.CreateStudent;
import com.teamsankya.studentapp.dao.StudentDao;
import com.teamsankya.studentapp.dao.StudentJdbcImpl;

public class StudentService {
	Logger LOGGER=Logger.getLogger(StudentService.class);
	private  StudentService() {}
	private static final StudentService STUDENT_SERVICE_MANAGER = new StudentService();
	public static StudentService getInstence() {
		return STUDENT_SERVICE_MANAGER;
	}
	
	
	public StudentDao daoCreater()
	{
		LOGGER.info("daoCreater() started..");
		Properties properties = new Properties();
		String path = getClass().getResource("/student-config.properties").getPath();
		LOGGER.info("resourse file location is="+path);
		try {
			LOGGER.info("creating filereader object..");
			FileReader fileReader = new FileReader(path);
			LOGGER.info("filereader object created..");
			properties.load(fileReader);
		} catch (Exception e1) {
			e1.printStackTrace(); 
		}
		StudentDao dao=null;
		try {
			LOGGER.info("dao_class object creating...");
			//dao = (StudentDao)Class.forName(properties.getProperty("dao_class")).newInstance();
			//dao=(StudentDao)Class.forName("com.teamsankya.dao.StudentJdbcImpl").newInstance();
			dao=new StudentJdbcImpl();
			LOGGER.info("dao_class object created...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("daoCreater() ended..");
		return dao;
	}

}
