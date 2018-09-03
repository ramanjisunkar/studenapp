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
int regno=(Integer)s.getAttribute("regno");
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
int pincode=(Integer)s.getAttribute("pincode");
String url="editstu?regno="+regno+"";
%>

	<form action="createprofile" method="post">

		<table width="1000">
			
			<tr>
				<td>
					<fieldset>
						<legend>
							<B>Student Basic Info ...</B>
						</legend>
						<table>
						<tr>
				
						<td>Reg.No:<a href="<%=url%>"><%=regno%></a></td>
								
							<tr>
							<tr>
								<td>First Name:<%=fname%></td>
								
							</tr>
							<tr>
								<td>Middle Name:<%=mname%></td>
								
							</tr>
							<tr>
								<td>Last Name:<%=lname%></td>
								<td>
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
								<td>Guardian First Name:<%=gfname%></td>
								
							</tr>
							<tr>
								<td>Guardian Middle Name:<%=gmname%></td>
								
							</tr>
							<tr>
								<td>Guardian Last Name:<%=glname%></td>
								
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
											<td>Address Type:<%=addtype%></td>
											
										</tr>
										<tr>
											<td>Address 1:<%=add1%></td>
											
										</tr>
										<tr>
										<tr>
											<td>Address 2:<%=add2%></td>
											
										</tr>
											
										
										<tr>
											<td>City:<%=city%></td>
											
										</tr>
										
										<tr>
											<td>Pincode:<%=pincode%></td>
											
										</tr>
									</table>
								</fieldset>
							</td>
						</tr>
					</table>
				</td>
				<td>
					
								</fieldset>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
		 
	</form>


</body>
</html>