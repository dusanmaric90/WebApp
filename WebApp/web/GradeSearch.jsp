<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
		
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Grade"%>
	<%
		List<Grade> grades = (List<Grade>) request.getAttribute("grades");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	
	
	<html>
		<head>
			<title>Pretraga Grade</title>
		</head>
		<body>
		
			<form action="./GradeSearchController" method="post">
				<table>
				
				
				
				
				<tr>
				
				<td>points</td>
				
				
				<td><input type="text" name="points" /></td>
				</tr>				
				
				
				<tr>
				
				<td>grade</td>
				
				
				<td><input type="text" name="grade" /></td>
				</tr>				
				
				
				<tr>
				
				<td>subject</td>
				
				
				<td><input type="text" name="subject" /></td>
				</tr>				
				
				
				<tr>
				
				<td>professor</td>
				
				
				<td><input type="text" name="professor" /></td>
				</tr>				
				
				
				<tr>
				
				<td>student</td>
				
				
				<td><input type="text" name="student" /></td>
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
			
			
			<c:if test="${!empty grades }">
				<p>Results:</p>
				<table id="gradesTable">
					<tr>
					
					
					<th>points</th>
					
					
					<th>grade</th>
					
					
					<th>subject</th>
					
					
					<th>professor</th>
					
					
					<th>student</th>
					
					
					</tr>
					<c:forEach var="grade" items="${grades }">
						<tr>
						
						
						
						<td>${grade.points } </td>
						
						
						
						<td>${grade.grade } </td>
						
						
						
						<td>${grade.subject } </td>
						
						
						
						<td>${grade.professor } </td>
						
						
						
						<td>${grade.student } </td>
						
						
						</tr>
					</c:forEach>
				</table>
			</c:if>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>