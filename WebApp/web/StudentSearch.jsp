<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Student"%>
	<%
		List<Student> students = (List<Student>) request.getAttribute("students");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	
	
	<html>
		<head>
			<title>Pretraga Student</title>
		</head>
		<body>
		
			<form action="./StudentSearchController" method="post">
				<table>
				
				
				
				
				<tr>
				
				<td>indexnumber</td>
				
				
				<td><input type="text" name="indexnumber" /></td>
				</tr>				
				
				
				<tr>
				
				<td>countexampassed</td>
				
				
				<td><input type="text" name="countexampassed" /></td>
				</tr>				
				
								
				
				
				
				
				<tr>
				
				<td>firstname</td>
				
				
				<td><input type="text" name="firstname" /></td>
				</tr>				
				
				
				<tr>
				
				<td>lastname</td>
				
				
				<td><input type="text" name="lastname" /></td>
				</tr>				
				
				
				<tr>
				
				<td> birthday (dd-MM-yyyy)</td>
				
				
				
				<td><input type="text" name="birthday" /></td>
				</tr>				
				
				
				<tr>
				
				<td>gender</td>
				
				
				<td>
					<select name="gender">
						<c:forEach var="tempGender" items="<%= model.Gender.values() %>">
							<option value="${tempGender}">${tempGender}</option>
						</c:forEach>
					</select>
				</td>
				
				</tr>				
				

					<c:if test="${badFormat }">
						<tr>
							<td>&nbsp;</td>
							<td><font color="red">ERROR: Bad date format!</font></td>
						</tr>
					</c:if>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" name="Search" value="Search" />
					</tr>
				</table>
			</form>
			
			
			<c:if test="${!empty students }">
				<p>Results:</p>
				<table id="studentsTable">
					<tr>
					
					
					<th>indexnumber</th>
					
					
					<th>countexampassed</th>
					
					
					
					</tr>
					<c:forEach var="student" items="${students }">
						<tr>
						
						
						<td>${student.indexnumber } </td>
						
						
						<td>${student.countexampassed } </td>
						
						
						

							<td>
								<form action="./StudentControllerShow" method="post">
									<input type="hidden" name="id" value="${student.id }"> <input
										type="submit" name="View Student" value="View Student">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>