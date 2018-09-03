
package com.teamsankya.studentapp.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;
import com.teamsankya.studentapp.dto.GuardianInfoBean;
import com.teamsankya.studentapp.dto.StudentAddressBean;
import com.teamsankya.studentapp.dto.StudentInfoBean;
import com.teamsankya.studentapp.dto.StudentMasterBean;

public class StudentJdbcImpl implements StudentDao {
	final static Logger LOGGER = Logger.getLogger(StudentJdbcImpl.class);
	public StudentJdbcImpl() {
		System.out.println("i am inside " + getClass().getSimpleName());
	}


	public int createStu(StudentMasterBean bean) throws SQLException {
		LOGGER.info("inside create student");
		Properties properties = new Properties();
		String path = getClass().getResource("/student-config.properties").getPath();
		try {
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			
			LOGGER.info("jdbc_driver obj creating");
			Class.forName(properties.getProperty("jdbc_driver")).newInstance();
			LOGGER.info("jdbc_driver obj created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("getConnection obj createing");
		Connection con = DriverManager.getConnection(properties.getProperty("db_url"));
		LOGGER.info("getConnection obj created");
		System.out.println(con);
		String insert = properties.getProperty("query_stuInsert");
		LOGGER.info(insert);
		System.out.println("Insert query=" + insert);
		PreparedStatement ps1 = con.prepareStatement(insert);
		System.out.println("preparestatement created" + ps1);
		System.out.println("prepared statem..." + bean.getInfo().getFname());
		ps1.setInt(1, bean.getInfo().getRegno());
		ps1.setString(2, bean.getInfo().getFname());
		ps1.setString(3, bean.getInfo().getLname());
		ps1.setString(4, bean.getInfo().getMname());
		int res = ps1.executeUpdate();

		PreparedStatement ps2 = con.prepareStatement(properties.getProperty("query_guarins"));
		ps2.setInt(1, bean.getAuar().getRengo());
		ps2.setString(2, bean.getAuar().getGfname());
		ps2.setString(3, bean.getAuar().getGmname());
		ps2.setString(4, bean.getAuar().getGlname());
		int res2 = ps2.executeUpdate();

		PreparedStatement ps3 = con.prepareStatement(properties.getProperty("query_stuaddr"));
		ps3.setInt(1, bean.getAddr().getRegno());
		ps3.setString(2, bean.getAddr().getAddr_Type());
		ps3.setString(3, bean.getAddr().getAddr1());
		ps3.setString(4, bean.getAddr().getAddr2());
		ps3.setString(5, bean.getAddr().getCity());
		ps3.setInt(6, bean.getAddr().getPincode());
		int res3 = ps3.executeUpdate();
		if (res >= 1 && res2 >= 1 && res3 >= 1) {
			return res;
		}
		return -1;

	}

	public void editStu(int regno)  {
		

	}

	public ResultSet deleteStu() throws SQLException {
		Properties properties = new Properties();
		String path = getClass().getResource("/student-config.properties").getPath();
		try {
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			LOGGER.info("jdbc_driver obj creating");
			Class.forName(properties.getProperty("jdbc_driver")).newInstance();
			LOGGER.info("jdbc_driver obj created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con;

		con = DriverManager.getConnection(properties.getProperty("db_url"));
		String getallquery = properties.getProperty("query_delete");
		java.sql.Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(getallquery);

		return res;
	}

	public StudentMasterBean getall(int regno)  {
		Logger log=Logger.getLogger(getClass().getSimpleName());

		Properties properties = new Properties();
		String path = getClass().getResource("/student-config.properties").getPath();
		try {
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			LOGGER.info("creating jdbc driver");
			Class.forName(properties.getProperty("jdbc_driver")).newInstance();
			LOGGER.info(" jdbc driver connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResultSet res=null;
		StudentMasterBean s=new StudentMasterBean();
		StudentInfoBean bean= new StudentInfoBean();
		GuardianInfoBean gbean=new GuardianInfoBean();
		StudentAddressBean add=new StudentAddressBean();
		try {
			Connection con = DriverManager.getConnection(properties.getProperty("db_url"));
			String getallquery = "select * from student_info sinf,student_addrinfo sainf,guardian_info ginf where sinf.regno=sainf.regno and sinf.regno=?";
			PreparedStatement ps=con.prepareStatement(getallquery);
			System.out.println(getallquery);
			 ps.setInt(1,regno);
			res= ps.executeQuery();
			 while(res.next())
			 {				bean.setFname(res.getString("sinf.firstname"));
			 				bean.setMname(res.getString("sinf.middlename"));
			 				bean.setLname(res.getString("sinf.lastname"));
			 				bean.setRegno(res.getInt("sinf.regno"));
			 				gbean.setGfname(res.getString("ginf.gfirstname"));
			 				gbean.setGmname(res.getString("ginf.gmiddlename"));
			 				gbean.setGlname(res.getString("ginf.glastname"));
			 				add.setAddr_Type(res.getString("sainf.addr_type"));
			 				add.setAddr1(res.getString("sainf.addr1"));
			 				add.setAddr2(res.getString("sainf.addr2"));
			 				add.setCity(res.getString("sainf.city"));
			 				add.setPincode(res.getInt("sainf.pincode"));
			 				
			 				s.setInfo(bean);
			 				s.setAuar(gbean);
			 				s.setAddr(add);
			 				
			 	}
				
			 } catch (Exception e) {
			}
	
		return s;

	

	}

	
	public int updateStu(int regno,StudentMasterBean bean) {
		LOGGER.info("Beginning update");
		
		Properties properties = new Properties();
		String path = getClass().getResource("/student-config.properties").getPath();
		try {
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			LOGGER.info("jdbc_obj createing");
			
			Class.forName(properties.getProperty("jdbc_driver")).newInstance();
			LOGGER.info("jdbc_obj created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("creating connection obj..");
		String updatestuinfo = properties.getProperty("query_updatestuinfo");
		
		Connection con=null;PreparedStatement ps1 =null;PreparedStatement ps2=null;int res=0;int res2=0;int res3=0;
		LOGGER.info("connection obj crated..");
		try {
			con = DriverManager.getConnection(properties.getProperty("db_url"));
			 ps1 = con.prepareStatement(updatestuinfo);
			 	ps1.setInt(4, bean.getInfo().getRegno());
				ps1.setString(1, bean.getInfo().getFname());
				ps1.setString(2, bean.getInfo().getLname());
				ps1.setString(3, bean.getInfo().getMname());
				 res = ps1.executeUpdate();
				
				 ps2 = con.prepareStatement(properties.getProperty("query_updateginfo"));
				ps2.setInt(4, bean.getAuar().getRengo());
				ps2.setString(1, bean.getAuar().getGfname());
				ps2.setString(2, bean.getAuar().getGmname());
				ps2.setString(3, bean.getAuar().getGlname());
				System.out.println(bean.getInfo().getFname());
				 res2 = ps2.executeUpdate();
				 
				 
				 LOGGER.info("");
				 
				 PreparedStatement ps3 = con.prepareStatement(properties.getProperty("query_updateaddr"));
					ps3.setInt(6, bean.getAddr().getRegno());
					ps3.setString(1, bean.getAddr().getAddr_Type());
					ps3.setString(2, bean.getAddr().getAddr1());
					ps3.setString(3, bean.getAddr().getAddr2());
					ps3.setString(4, bean.getAddr().getCity());
					ps3.setInt(5, bean.getAddr().getPincode());
					res3 = ps3.executeUpdate();

				
				 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		if (res >= 1 && res2 >= 1 && res3>=1) {
			LOGGER.info("update student ended jdbc driver");
			return res;
		}
		LOGGER.info("update student ended jdbc driver");
		return -1;
		
	}


	@Override
	public int delete(int regno) {
		Properties properties = new Properties();
		String path = getClass().getResource("/student-config.properties").getPath();
		try {
			FileReader fileReader = new FileReader(path);
			properties.load(fileReader);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			LOGGER.info("jdbc_driver obj creating");
			Class.forName(properties.getProperty("jdbc_driver")).newInstance();
			LOGGER.info("jdbc_driver obj created");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection con;
		int res=0;
		try {
			con = DriverManager.getConnection(properties.getProperty("db_url"));
			String delete = properties.getProperty("query_delete");
			PreparedStatement ps=con.prepareStatement(delete);
			ps.setInt(1,regno);
			res=ps.executeUpdate(delete);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(res>=1)
		{
			return res;
		}
		
		return 0;
	}

}
