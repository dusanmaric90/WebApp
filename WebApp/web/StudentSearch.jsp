<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
		
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Student"%>
	<%
		List<Student> students = (List<Student>) request.getAttribute("students");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	<link href="style.css" type="text/css" rel="stylesheet">
	
	<html>
		<head>
			<title>Pretraga Student</title>
		</head>
		<body>
			<%@include  file="menu.jsp"  %>
			<div class ="content">
			<div class = "listCentar"> <h2>Search Student</h2> </div>
			<div class = "listCentarGrey">
			<form action="./StudentSearchController" method="post">
				<table>
				
				
				

				
				<tr>
				
				<td>index_number</td>
				
				
				<td><input type="text" name="index_number" /></td>
				</tr>				
				

				
				<tr>
				
				<td>count_exam_passed</td>
				
				
				<td><input type="text" name="count_exam_passed" /></td>
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
					<option value="null"></option>
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
						<td><input type="submit" name="Search" value="Search" class = "button"/>
					</tr>
				</table>
			</form>
			</div>
			
			<c:if test="${!empty students }">
				<div class = "listCentar"><h2>Results:</h2> </div>
				<div class = "listCentarGrey">
				<table id="studentsTable" border="1">
					<tr>
					
					
					<th>index_number</th>
					
					
					<th>count_exam_passed</th>
					
					
					
					
					
					<th>firstname</th>
					
					
					<th>lastname</th>
					
					
					<th>birthday</th>
					
					
					<th>gender</th>
					
					</tr>
					<c:forEach var="student" items="${students }">
						<tr>
						
						
						
						<td>${student.index_number } </td>
						
						
						
						<td>${student.count_exam_passed } </td>
						
						
						
						
						
						
						<td>${student.firstname } </td>
						
						
						
						<td>${student.lastname } </td>
						
						
						
						<td> <fmt:formatDate pattern="dd-MM-yyyy" value="${student.birthday}" /></td>
						
						
						
						
						<td>${student.gender } </td>
						
						</tr>
					</c:forEach>
				</table>
				</div>
			</c:if>
	
		</div>
		</body>
	</html>