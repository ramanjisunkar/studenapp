<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
HttpSession s=request.getSession(false);
int regno=(int)s.getAttribute("regno");
String fname=(String)s.getAttribute("fname");
String mname=(String)s.getAttribute("mname");
String lname=(String)s.getAttribute("lname");
String gfname=(String)s.getAttribute("gfname");
String gmname=(String)s.getAttribute("gmname");
String glname=(String)s.getAttribute("glname");
String addtype=(String)s.getAttribute("addtype");
String add1=(String)s.getAttribute("add1");
String add2=(String)s.getAttribute("add2");
String city=(String)s.getAttribute("city");
int pincode=(int)s.getAttribute("pincode");
%>

	<form action="updatestu" method="post">

		<table width="1000">
			
			<tr>
				<td>
					<fieldset>
						<legend>
							<B>Student Basic Info ...</B>
						</legend>
						<table>
						<tr>
											<td>Reg.No</td>
											<td><input type="number" name="regno" 
												readonly="readonly" value="<%=regno%>"/></td>
										</tr>
						<tr>
								<td>First Name</td>
								<td><input type="text" name="fnm"
									placeholder="Enter First Name" required="required" value="<%=fname%>"/></td>
							</tr>
							<tr>
								<td>Middle Name</td>
								<td><input type="text" name="mnm"
									placeholder="Enter Middle Name" required="required" value="<%=mname%>"/></td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td><input type="text" name="lnm"
									placeholder="Enter Last Name" required="required" value="<%=lname%>"/></td>
							</tr>
							
						</table>
					</fieldset>
				</td>
				<td>
					<fieldset>
						<legend>
							<B>Guardian Info ...</B>
						</legend>
						<table>
							<tr>
								<td>Guardian First Name</td>
								<td><input type="text" name="gfnm"
									placeholder="Enter Guardian First Name" required="required" value="<%=gfname%>"/></td>
							</tr>
							<tr>
								<td>Guardian Middle Name</td>
								<td><input type="text" name="gmnm"
									placeholder="Enter Guardian Middle Name" required="required" value="<%=gmname%>"/></td>
							</tr>
							<tr>
								<td>Guardian Last Name</td>
								<td><input type="text" name="glnm"
									placeholder="Enter Guardian Last Name" required="required" value="<%=glname%>"/></td>
							</tr>
							
						</table>
					</fieldset>
				</td>
			</tr>
		</table>
<table>
			<tr>
				<td>
					<table width="500">
						<tr>
							<td>
								<fieldset>
									<legend>
										<B>Student Present Address ...</B>
									</legend>
									<table>
										<tr>
											<td>Address Type</td>
											<td><input type="text" name="presentaddr" value="Present"
												readonly="readonly" /></td>
										</tr>
										<tr>
											<td>Address 1</td>
											<td><input type="text" name="pre.addr1"
												placeholder="Enter Address 1" required="required" value="<%=add1%>"/></td>
										</tr>
										<tr>
											<td>Address 2</td>
											<td><input type="text" name="pre.addr2"
												placeholder="Enter Address 2" required="required" value="<%=add2%>"/></td>
										</tr>
										
										<tr>
											<td>City</td>
											<td><input type="text" name="pre.city"
												placeholder="Enter City" required="required" value="<%=city%>"/></td>
										</tr>
										
										<tr>
											<td>Pincode</td>
											<td><input type="number" name="pre.pincode"
												placeholder="Enter Pincode" required="required"value="<%=pincode%>" /></td>
										</tr>
									</table>
								</fieldset>
							</td>
						</tr>
					</table>
				</td>
				
								</fieldset>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<BR><BR>
		<input type="submit" value="Update Profile" /> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="Submit" value="Reset" />

		 
	</form>
</body>
</html>