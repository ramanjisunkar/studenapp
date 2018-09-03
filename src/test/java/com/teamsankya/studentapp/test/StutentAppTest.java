package com.teamsankya.studentapp.test;

import org.junit.Test;

import junit.framework.TestCase;
import net.sourceforge.jwebunit.WebTester;

public class StutentAppTest extends TestCase {
	
	private static final String BASE_URL="http://localhost:8080/studentapp/";
	private WebTester tester=new WebTester();
	@Override
	protected void setUp() throws Exception {
		tester.getTestContext().setBaseUrl(BASE_URL);
	}
	@Test
	public void page1Test()
	{
		tester.beginAt("Createstu.jsp");
		tester.setFormElement("regno","3");
		tester.setFormElement("fnm","ram");
		tester.setFormElement("mnm","sunkara");
		tester.setFormElement("lnm","s");
		tester.setFormElement("gfnm","shiva");
		tester.setFormElement("gmnm","anandam");
		tester.setFormElement("glnm","n");
		tester.setFormElement("presentaddr","Present");
		tester.setFormElement("pre.addr1","srinagar");
		tester.setFormElement("pre.addr2","gg");
		tester.setFormElement("pre.city","bangalore");
		tester.setFormElement("pre.pincode","560021");
		tester.submit();
		tester.assertTextPresent("Student data successfully inserted");
		//tester.assertTextPresent("Enter Regno to display & Edit");
		tester.clickLinkWithText("click here to display and Edit");
		tester.assertTextPresent("Enter Regno to display & Edit");
		}
	public void page2Test()
	{
		tester.beginAt("success.jsp");
		tester.setFormElement("regno","2");
		tester.submit();
	}
	
}
